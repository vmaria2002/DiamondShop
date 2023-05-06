package com.maria.ass1.model.builder;

import com.maria.ass1.model.cart.ShoppingCart;
import com.maria.ass1.model.products.Product;

public class ShoppingCartBuilder {
    private ShoppingCart shoppingCart;

    public ShoppingCartBuilder(){

        shoppingCart = new ShoppingCart();
    }

    public ShoppingCartBuilder setProduct(Product product){

        shoppingCart.setProduct(product);
        return this;
    }

    public ShoppingCartBuilder setUserId(int userId){

        shoppingCart.setUserId(userId);
        return this;
    }

    public ShoppingCartBuilder setPrice(int price){

        shoppingCart.setPrice(price);
        return this;
    }

    public ShoppingCartBuilder setDeals(String deal){

        shoppingCart.setProduct(deal);
        return this;
    }

    public ShoppingCart build(){
        return shoppingCart;
    }
}
