package com.maria.ass1.model.decorator.observer;

import com.maria.ass1.model.user.Customer;

import java.util.ArrayList;
import java.util.List;

public class MyObservable {
    public List<MyObserver> observers = new ArrayList<MyObserver>();

    public void registerObserver(MyObserver o){

        observers.add(o);
    }

    public void unregisterObserver(MyObserver o){

        observers.remove(o);
    }

    public void notifyObserver(Customer user, Notification notification){
        user.update(notification);
    }
}
