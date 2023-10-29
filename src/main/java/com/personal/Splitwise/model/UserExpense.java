package com.personal.Splitwise.model;

import com.personal.Splitwise.model.constant.BaseModel;
import com.personal.Splitwise.model.constant.UserExpenseType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "split_user_expense")
public class UserExpense extends BaseModel {
    @ManyToOne(cascade = CascadeType.MERGE)
    private User user;

    private double amount;

    @Enumerated(EnumType.STRING)
    private UserExpenseType userExpenseType;
}
