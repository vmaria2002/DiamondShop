package com.maria.ass1.model.cart;

import com.maria.ass1.model.products.Product;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import javax.validation.constraints.NotNull;

@Entity
public class ShoppingCart implements Cart {
    @Id
    @GeneratedValue
    private int id;

    @ManyToOne
    private String product;

    @NotNull
    private int price;

    @NotNull
    private int userId;

    @NotNull
    private String deals = "";

    public ShoppingCart(){}

    public int getId() {
        return id;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = String.valueOf(product);
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }


    @Override
    public void setProduct(String deal) {

    }

    public void addProduct(String nume){
        this.product = this.product + " " + nume;
    }
}
