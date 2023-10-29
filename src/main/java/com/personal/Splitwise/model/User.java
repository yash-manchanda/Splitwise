package com.personal.Splitwise.model;

import com.personal.Splitwise.model.constant.BaseModel;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToMany;
import lombok.*;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity(name = "split_user")
public class User extends BaseModel {
    private String name;
    private String email;
    private String phoneNumber;
    @ManyToMany(mappedBy = "users", fetch = FetchType.EAGER)
    private List<Group> groups;
}
