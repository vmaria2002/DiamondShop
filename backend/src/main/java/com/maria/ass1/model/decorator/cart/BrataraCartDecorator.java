package com.maria.ass1.model.decorator.cart;

import com.maria.ass1.model.cart.Cart;

public class BrataraCartDecorator extends CartDecorator {
    public BrataraCartDecorator(Cart decoratedCart) {
        super(decoratedCart);
    }
    public void setProdus(String numeProdus){
        decoratedCart.setProduct(numeProdus);
        addBratara();
    }

    private void addBratara(){
        decoratedCart.addProduct("BRACELET");
    }
}
