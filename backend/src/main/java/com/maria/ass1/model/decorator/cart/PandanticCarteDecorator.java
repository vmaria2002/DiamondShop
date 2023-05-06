package com.maria.ass1.model.decorator.cart;

import com.maria.ass1.model.cart.Cart;

public class PandanticCarteDecorator extends CartDecorator {
    public PandanticCarteDecorator(Cart decoratedCart) {
        super(decoratedCart);
    }
    public void setProdus(String numeProdus){
        decoratedCart.setProduct(numeProdus);
        addPandantiv();
    }

    private void addPandantiv(){
        decoratedCart.addProduct("CHARM");
    }
}
