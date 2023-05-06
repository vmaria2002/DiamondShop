package com.maria.ass1.model.user;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.maria.ass1.model.decorator.observer.MyObserver;
import com.maria.ass1.model.decorator.observer.Notification;
import com.maria.ass1.validators.CountryConnstraint;
import com.maria.ass1.validators.PhoneNumberConstraint;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Setter
@Getter
@Entity
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

public class Customer extends User implements Comparable<Customer>, MyObserver {
    @CountryConnstraint(message = "Country name is mandatory. It should start with a capital letter and contain at least 3 characters.")
    private String country;
    @CountryConnstraint(message = "City name is mandatory. It should start with a capital letter and contain at least 3 characters.")
    private String city;
    @CountryConnstraint(message = "Street name is mandatory. It should start with a capital letter and contain at least 3 characters.")
    private String street;
    private Integer number;
    @PhoneNumberConstraint(message = "Phone is mandatory. It should contain 10 digits.")
    private String phone;

    private List<Notification> notifications = new ArrayList<>();
    public Customer() {

    }
    public Customer(String firstName,String lastName,String userName,String password,String email,String country,String city,String street, Integer number, String phone)
    {
        super(firstName,lastName,userName,password,email);
        this.country=country;
        this.city=city;
        this.street=street;
        this.phone=phone;
        this.number=number;
    }

    @Override
    public int compareTo(Customer customer) {
        String name1=this.getName()+" "+this.getName();
        String name2=customer.getUsername()+" "+customer.getUsername();
        return name1.compareTo(name2);
    }

    @Override
    public void update(Notification notification) {

        notifications.add(notification);
    }
}
