package com.maria.ass1.dao;

import com.maria.ass1.model.cart.ShoppingCart;
import com.maria.ass1.model.products.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface ShoppingCartDAO extends CrudRepository<ShoppingCart, Integer> {
    List<ShoppingCart> findByUserId(int userId);
    List<ShoppingCart> findByType(String type);

}
