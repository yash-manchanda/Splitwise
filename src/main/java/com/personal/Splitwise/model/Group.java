package com.personal.Splitwise.model;

import com.personal.Splitwise.model.constant.BaseModel;
import com.personal.Splitwise.model.constant.Currency;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Entity(name = "split_group")
public class Group extends BaseModel {
    private String name;
    private String description;
    private double totalAmountSpent;

    @Enumerated(EnumType.STRING)
    private Currency defaultCurrency;

    @OneToMany(cascade = CascadeType.MERGE)
    @JoinColumn(name = "split_group_id")
    private List<Expense> expenses;

    @ManyToMany
    private List<User> users;
}
