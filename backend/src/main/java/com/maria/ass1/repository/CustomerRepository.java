package com.maria.ass1.repository;

import com.maria.ass1.model.user.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {
    Customer findByUserNameAndPassword(String userName,String password);
    Customer findByUserName(String userName);
}
