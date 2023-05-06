package com.maria.ass1.dao;

import com.maria.ass1.model.products.Product;
import jakarta.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotNull;
import java.util.List;

@Repository
@Transactional
public interface ProdusDAO extends CrudRepository<Product, Long> {
    boolean findByName(String name);
    List<Product> findByPrice(Float  price);
    boolean findByCantity(@NotNull(message = "Availability is mandatory.") Boolean cantity);
    boolean findByMaterial(String material);
    List<Product> findBySize(Integer size);
    List<Product> findByType(String type);

}
