package com.maria.ass1.model.builder;

import com.maria.ass1.model.decorator.observer.Notification;
import com.maria.ass1.model.user.Customer;

public class NotificationBuilder {
    private Notification notification;

    public NotificationBuilder(){

        notification = new Notification();
    }

    public NotificationBuilder setUser(Customer user){

        notification.setUser(user);
        return this;
    }

    public NotificationBuilder setNotification(String notificationMessage){

        notification.setNotification(notificationMessage);
        return this;
    }

    public Notification build(){

        return notification;
    }
}
