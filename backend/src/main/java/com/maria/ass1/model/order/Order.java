package com.maria.ass1.model.order;

import com.maria.ass1.model.decorator.observer.Notification;
import com.maria.ass1.model.products.Product;
import com.maria.ass1.model.user.Customer;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
public class Order {
    private Long idOrder;
    private Long idCustomer;
    @ManyToOne(fetch = FetchType.LAZY)
    private Customer client;
    private String status;
    private String numeProduct;
    private Product product;
    private  String nameCustomer;
    private LocalDate date;
    private Double total;



    public int compareTo(Order o) {
        return (int) (this.getIdCustomer()-o.getIdCustomer());
    }

    public void notifyObserver(Customer user, Notification notification) {
    }
}
