package com.maria.ass1.repository;

import com.maria.ass1.model.products.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdusRepoditory extends JpaRepository<Product,Long> {
    List<Product> findAll(String material);

    void createReport();
}
