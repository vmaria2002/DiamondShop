package com.maria.ass1.model.decorator.cart;

import com.maria.ass1.model.cart.Cart;

public class LantisorCartDecorator extends CartDecorator {
    public LantisorCartDecorator(Cart decoratedCart) {
        super(decoratedCart);
    }

    public void setProdus(String numeProdus){
        decoratedCart.setProduct(numeProdus);
        addLantisor();
    }

    private void addLantisor(){
        decoratedCart.addProduct("NECKLACE");
    }
}
