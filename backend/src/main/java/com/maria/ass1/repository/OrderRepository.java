package com.maria.ass1.repository;

import com.maria.ass1.model.order.Order;
import com.maria.ass1.model.products.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order,Long> {
    Order findFirstByOrderByIdDesc();
    List<Order> findCommandByClient_Id(Long id);
    List<Product> findByIdOrderId(Long id);
    List<Product> findOrderItemByItem(Product item);

    void deleteById(Product id);

}
