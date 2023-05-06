package com.maria.ass1.dao;

import com.maria.ass1.model.user.Admin;
import jakarta.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public interface AdminDAO  extends CrudRepository<Admin, Long> {
    List<Admin> findByLastName(String lastName);

}

