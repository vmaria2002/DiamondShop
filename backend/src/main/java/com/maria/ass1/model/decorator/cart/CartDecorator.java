package com.maria.ass1.model.decorator.cart;

import com.maria.ass1.model.cart.Cart;

public class CartDecorator implements Cart{
    protected Cart decoratedCart;

    public CartDecorator(Cart decoratedCart){

        this.decoratedCart = decoratedCart;
    }

    @Override
    public void setProduct(String nameProduct) {

        decoratedCart.setProduct(nameProduct);
    }

    @Override
    public void addProduct(String name) {
        decoratedCart.addProduct(name);
    }

    @Override
    public String getProduct() {
        return decoratedCart.getProduct();
    }


}
