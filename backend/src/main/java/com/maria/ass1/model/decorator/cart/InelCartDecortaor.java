package com.maria.ass1.model.decorator.cart;

import com.maria.ass1.model.cart.Cart;

public class InelCartDecortaor extends CartDecorator {

    public InelCartDecortaor(Cart decoratedCart) {
        super(decoratedCart);
    }

    public void setProdus(String numeProdus){
        decoratedCart.setProduct(numeProdus);
        addInel();
    }

    private void addInel(){
        decoratedCart.addProduct("RING");
    }
}
