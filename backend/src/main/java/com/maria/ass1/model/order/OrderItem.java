package com.maria.ass1.model.order;

import com.maria.ass1.model.products.Product;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
public class OrderItem {
    @ManyToOne
    @MapsId("orderId")
    @JoinColumn(name = "order_id")
    Order command;
    @ManyToOne
    @MapsId("itemId")
    @JoinColumn(name="item_id")
    Product item;
    int cantity;
}
