package com.personal.Splitwise.model;

import com.personal.Splitwise.model.constant.BaseModel;
import com.personal.Splitwise.model.constant.Currency;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "split_expense")
public class Expense extends BaseModel {
    private double amount;
    private String description;

    @Enumerated(EnumType.STRING)
    private Currency currency;

    @OneToMany(cascade = CascadeType.MERGE)
    @JoinColumn(name = "split_expense_id")
    private List<UserExpense> userExpenses;
}
