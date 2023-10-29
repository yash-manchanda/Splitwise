package com.personal.Splitwise.service.strategy;

import com.personal.Splitwise.dto.TransactionDTO;
import com.personal.Splitwise.model.Expense;

import java.util.List;

public interface SettleUpStrategy {
    List<TransactionDTO> settleUp(List<Expense> expenses);
}
