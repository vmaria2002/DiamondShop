package com.maria.ass1.model.decorator.cart;

import com.maria.ass1.model.cart.Cart;

public class CerceiCartDecorator  extends CartDecorator {
    public CerceiCartDecorator(Cart decoratedCart) {
        super(decoratedCart);

    }
    public void setProdus(String numeProdus){
        decoratedCart.setProduct(numeProdus);
        addCercei();
    }

    private void addCercei(){
        decoratedCart.addProduct("EARRINGS");
    }
}
