package com.maria.ass1.dao;

import com.maria.ass1.model.order.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Repository
@Transactional
public interface OrderDAO extends CrudRepository<Order, Integer>{
    List<Order> findByUserId(int userId);
}
