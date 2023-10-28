package com.personal.Splitwise.model;

import com.personal.Splitwise.model.constant.BaseModel;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "split_user")
public class User extends BaseModel {
    private String name;
    private String email;
    private String phoneNumber;
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Group> groups;
}
