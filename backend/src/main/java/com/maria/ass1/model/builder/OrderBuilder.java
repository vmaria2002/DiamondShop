package com.maria.ass1.model.builder;

import com.maria.ass1.model.order.Order;
import com.maria.ass1.model.user.Customer;

public class OrderBuilder {
    private Order order;

    public OrderBuilder(){

        order = new Order();
    }

    public OrderBuilder setUsername(String numeCustomer){
        order.setNameCustomer(numeCustomer);
        return this;
    }

    public OrderBuilder setProductName(String productName){

        order.setNumeProduct(productName);
        return this;
    }

    public OrderBuilder setUser(Customer user){

        order.setClient(user);
        return this;
    }

    public OrderBuilder setProduct(String product){

        return this;
    }

    public OrderBuilder setStatus(String status){
        order.setStatus(status);
        return this;
    }


    public Order build(){
        return order;
    }
}
