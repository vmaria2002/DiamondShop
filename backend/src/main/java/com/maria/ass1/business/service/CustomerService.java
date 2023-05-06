package com.maria.ass1.business.service;



import com.maria.ass1.model.order.Order;
import com.maria.ass1.model.products.Product;
import com.maria.ass1.model.user.Customer;
import com.maria.ass1.model.user.User;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.MethodArgumentNotValidException;

import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.Set;

@Service
public interface CustomerService {
    Customer saveCustomer(Customer customerDto) throws ConstraintViolationException;

    Customer saveCustomer(CustomerService customerDto) throws DataIntegrityViolationException, MethodArgumentNotValidException, Exception, Throwable;
    List<Customer> getAllCustomers();
    Customer getCustomerById(Long id);
    Customer updateCustomer(CustomerService customerDto);
    Customer deleteCustomer(Long id);
    Customer findByUserName(CustomerService authDTO);
    void addMyFavoriteList(Long idCustomer, Long idItem);
    void removeMyFavoriteList(Long idCustomer, Long idItem);

    List<Order> getComands(Long id);

    Set<Product> listMyFavoriteList(Long idCustomer);

    void createReportFav(Long id);


    User getUser(Long id);
}
