package com.maria.ass1.dao;

import com.maria.ass1.model.decorator.observer.Notification;
import jakarta.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public interface NotificationDAO extends CrudRepository <Notification, Integer>{
   // List<Notification> save(Notification notification);
}
