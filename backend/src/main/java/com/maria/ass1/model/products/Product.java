package com.maria.ass1.model.products;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;
import org.springframework.format.annotation.NumberFormat;

import javax.validation.constraints.Min;
import java.util.HashSet;
import java.util.Set;
@Getter
@Setter
public class Product implements Comparable<Product>{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idItem;
    @Column(unique = true, length = 100)
    private String name;
    @javax.validation.constraints.NotNull(message = "Price is mandatory.")
    @NumberFormat
    @Min(value = 1)
    private Double price;
    @javax.validation.constraints.NotNull(message = "Description is mandatory.")
    private String description;
    private String material;
    @javax.validation.constraints.NotNull(message = "Availability is mandatory.")
    private Boolean availability;
    private Integer size;
    @NotNull
    private Type type;
    private String nameImg;



    public Product(String name, Double price, String description, String material, Boolean availability, Integer size, Type type, String nameImg) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.material = material;
        this.availability = availability;
        this.size = size;
        this.nameImg=nameImg;
        this.type = type;
    }

    public Product() {

    }

    public Product(Long id) {
    }

    public Product(String brataraAna, double v, String foarteFrumoasa, String aur, int i, int i1, Type bracelet) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.material = material;
        this.availability = availability;
        this.size = size;
        this.nameImg=nameImg;
        this.type = type;
    }

    @Override
    public int compareTo(@NotNull Product o) {
        return 0;
    }

    public int getCantity() {
        return size;
    }

    public void setCantity(int i) {
        size=i;
    }

    public double getPrice() {
        return price;
    }

    public <T> Object save(T any) {
        return any;
    }
}
