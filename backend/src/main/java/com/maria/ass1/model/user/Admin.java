package com.maria.ass1.model.user;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Data
public class Admin extends User {
    public Admin(String firstName, String lastName, String userName, String password, String email) {
        super(firstName,lastName,userName,password,email);
    }
    public Admin() {

    }
}
