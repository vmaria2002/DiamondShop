package com.maria.ass1.business.service;


import com.maria.ass1.exception.ResourceNotFoundException;
import com.maria.ass1.model.order.Order;
import com.maria.ass1.model.products.Product;
import com.maria.ass1.model.user.Customer;
import com.maria.ass1.model.user.User;
import com.maria.ass1.repository.CustomerRepository;
import com.maria.ass1.repository.OrderRepository;
import com.maria.ass1.repository.ProdusRepoditory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.MethodArgumentNotValidException;


import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;

    private final ProdusRepoditory itemRepository;
    private final OrderRepository commandRepository;
    private final ProdusRepoditory orderItemRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository, ProdusRepoditory itemRepository, OrderRepository commandRepository, ProdusRepoditory orderItemRepository) {
        this.customerRepository = customerRepository;
        this.itemRepository = itemRepository;
        this.commandRepository = commandRepository;
        this.orderItemRepository = orderItemRepository;
    }


    @Override
    public Customer saveCustomer(Customer customerDto) throws ConstraintViolationException {
        Customer customer=new Customer();

        customer.setStreet(customerDto.getStreet());
        customer.setCity(customerDto.getCity());
        customer.setCountry(customerDto.getCountry());
        customer.setPhone(customerDto.getPhone());
        customer.setEmail(customerDto.getEmail());
        customer.setNumber(customerDto.getNumber());
        Customer newCustomer=customerRepository.save(customer);

         return newCustomer;
    }

    @Override
    public Customer saveCustomer(CustomerService customerDto) throws DataIntegrityViolationException, MethodArgumentNotValidException, Exception, Throwable {
        return null;
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer getCustomerById(Long id) {
        return customerRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Customer","Id",id,HttpStatus.NOT_FOUND));
    }

    @Override
    public Customer updateCustomer(CustomerService customerDto) {
        return null;
    }


    public Customer updateCustomer(Customer customerDto) {
        // we need to check whether employee with given id exist in database
        Customer customer=new Customer();
        customer.setId(customerDto.getId());
        customer.setStreet(customerDto.getStreet());
        customer.setCity(customerDto.getCity());
        customer.setCountry(customerDto.getCountry());
        customer.setNumber(customerDto.getNumber());
        customer.setPhone(customerDto.getPhone());
        customer.setEmail(customerDto.getEmail());
        customer.setNumber(customerDto.getNumber());
        Customer existingCustomer=customerRepository.findById(customer.getId()).orElseThrow(()->new ResourceNotFoundException("Customer","Id",customer.getId(),HttpStatus.NOT_FOUND));

        // save existing customer to database
        customerRepository.save(existingCustomer);
        return existingCustomer;
    }

    @Override
    public Customer deleteCustomer(Long id) {
        // check whether a customer exist in database
        Customer customerDeleted=customerRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Customer","Id",id,HttpStatus.NOT_FOUND));

        List<Product>items=itemRepository.findAll();


        List<Order> commands=commandRepository.findCommandByClient_Id(id);
        for(Order command:commands){
            List<Product> orderItemList = orderItemRepository.findAllById(Collections.singleton(id));

            for (Product o : orderItemList) {
                orderItemRepository.deleteById(id);
            }

        }
        customerRepository.deleteById(id);
        return customerDeleted;
    }

    @Override
    public Customer findByUserName(CustomerService authDTO) {
        return null;
    }


    public Customer findByUserName(Customer authDTO) {
        Customer customer=customerRepository.findByUserName(authDTO.getUsername());

        if(customer==null){
            throw new ResourceNotFoundException("Customer","Username",authDTO.getUsername(), HttpStatus.NOT_FOUND);
        }
        else{

        }
        return customer;
    }

    @Override
    public void addMyFavoriteList(Long idCustomer,Long idItem) {
        Customer customer=customerRepository.findById(idCustomer).get();
        Product item=itemRepository.findById(idItem).get();
        customerRepository.save(customer);

    }
    public void removeMyFavoriteList(Long idCustomer,Long idItem)
    {
        Customer customer=customerRepository.findById(idCustomer).get();
        Product item=itemRepository.findById(idItem).get();
        customerRepository.save(customer);
    }

    @Override
    public Set<Product> listMyFavoriteList(Long idCustomer) {
        Customer customer=customerRepository.findById(idCustomer).get();
        return null;
    }

    public void createReportFav(Long id){
        Set items=listMyFavoriteList(id);
        Customer customer=customerRepository.findById(id).get();
        String name="./"+customer.getName()+"_"+".csv";
        Object CsvReport = null;

    }

    @Override
    public User getUser(Long id) {
        return customerRepository.findByUserName(String.valueOf(id));
    }

    @Override
    public List<Order> getComands(Long id) {
        Customer customer=customerRepository.findById(id).get();
        List<Order>commands=new ArrayList<>();
        for(Order command:commandRepository.findAll()){
            if(command.getClient().equals(customer)){
                commands.add(command);
            }
        }
        return commands;
    }

}
