package com.maria.ass1.repository;

import com.maria.ass1.model.user.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin,Long> {
    Admin findByUserNameAndPassword(String userName,String password);
    Admin findByUserName(String userName);
}
