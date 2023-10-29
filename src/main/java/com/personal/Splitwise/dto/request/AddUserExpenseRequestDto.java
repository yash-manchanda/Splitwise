package com.personal.Splitwise.dto.request;

import com.personal.Splitwise.model.constant.Currency;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

public class AddUserExpenseRequestDto {
    private double amount;
    private String description;
    private Currency currency;
    private int groupId;
}
