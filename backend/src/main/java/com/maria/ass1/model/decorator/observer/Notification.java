package com.maria.ass1.model.decorator.observer;

import com.maria.ass1.model.order.Order;
import com.maria.ass1.model.user.Customer;
import jakarta.persistence.*;

import javax.validation.constraints.NotNull;

@Entity
public class Notification {
    @Id
    @GeneratedValue
    private int id;

    @NotNull
    private String notification;

    @ManyToOne(cascade = {CascadeType.ALL})
    private Customer user;

    @ManyToOne(cascade = {CascadeType.ALL})
    private Order order;

    public Notification(){}

    public int getId() {
        return id;
    }

    public String getNotification() {
        return notification;
    }

    public void setNotification(String notification) {
        this.notification = notification;
    }

    public Customer getUser() {
        return user;
    }

    public void setUser(Customer user) {
        this.user = user;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
