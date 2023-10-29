package com.personal.Splitwise.service.strategy;

import com.personal.Splitwise.dto.TransactionDTO;
import com.personal.Splitwise.model.Expense;
import com.personal.Splitwise.model.User;
import com.personal.Splitwise.model.UserExpense;
import com.personal.Splitwise.model.constant.UserExpenseType;

import java.util.*;

public class HeapBasedStrategyImpl implements SettleUpStrategy{
    @Override
    public List<TransactionDTO> settleUp(List<Expense> expenses) {
        HashMap<User, Double> eachUserExpense = new HashMap<>();
        List<TransactionDTO> transactions = new ArrayList<>();
        expenses.forEach(expense -> {
            expense.getUserExpenses().forEach(userExpense -> {
                User user = userExpense.getUser();
                Double currOutstandingAmount = eachUserExpense.getOrDefault(user, 0.00);
                Double outstandingAmount = calculateOutstandingAmount(currOutstandingAmount, userExpense);
                eachUserExpense.put(user, outstandingAmount);
            });
        });

        PriorityQueue<Map.Entry<User,Double>> maxHeap = new PriorityQueue<>(
                (o1, o2) -> Double.compare(o2.getValue(), o1.getValue())
        );
        PriorityQueue<Map.Entry<User,Double>> minHeap = new PriorityQueue<>(
                Comparator.comparingDouble(Map.Entry::getValue)
        );

        for(Map.Entry<User, Double> entry : eachUserExpense.entrySet()){
            if(entry.getValue() > 0){
                maxHeap.add(entry);
            }
            else if(entry.getValue() < 0){
                minHeap.add(entry);
            }
            else{
                System.out.println(entry.getKey().getName() + "doesnt have any outstanding");
            }
        }

        while (!minHeap.isEmpty()){
            Map.Entry<User, Double> hadToPay = minHeap.poll();
            Map.Entry<User, Double> paid = maxHeap.poll();

            double settleUpBalance = Math.min(Math.abs(hadToPay.getValue()), paid.getValue());
            TransactionDTO transactionDTO = new TransactionDTO(
                    hadToPay.getKey().getName(),
                    paid.getKey().getName(),
                    settleUpBalance);
            transactions.add(transactionDTO);

            double balanceLeft = hadToPay.getValue() + paid.getValue();
            if(balanceLeft > 0){
                paid.setValue(balanceLeft);
                maxHeap.add(paid);
            }
            else if(balanceLeft < 0){
                hadToPay.setValue(balanceLeft);
                minHeap.add(hadToPay);
            }
            else{
                System.out.println("No transaction for user : "
                        +hadToPay.getKey().getName()+", "+paid.getKey().getName());
            }
        }
        return null;
    }

    private Double calculateOutstandingAmount(Double currOutstandingBal,UserExpense userExpense){
        if(userExpense.getUserExpenseType().equals(UserExpenseType.PAID)){
            return currOutstandingBal + userExpense.getAmount();
        }else {
            return currOutstandingBal - userExpense.getAmount();
        }
    }
}
