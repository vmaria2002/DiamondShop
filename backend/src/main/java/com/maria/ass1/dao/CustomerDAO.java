package com.maria.ass1.dao;

import com.maria.ass1.model.user.Admin;
import com.maria.ass1.model.user.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Repository
@Transactional
public interface CustomerDAO extends CrudRepository<Customer, Integer>{
    List<Customer> findByName(String name);
    List<Customer> findComnad(Long  id);


}
