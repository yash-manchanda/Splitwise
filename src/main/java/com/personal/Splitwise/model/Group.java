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
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "split_group")
public class Group extends BaseModel {
    private String name;
    private String description;
    private double totalAmountSpent;

    @Enumerated(EnumType.STRING)
    private Currency defaultCurrency;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "group")
    private List<Expense> expenses;

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "groups")
    private List<User> users;
}
