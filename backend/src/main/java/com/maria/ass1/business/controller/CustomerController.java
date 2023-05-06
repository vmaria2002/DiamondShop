package com.maria.ass1.business.controller;

import com.maria.ass1.business.service.CommandService;
import com.maria.ass1.business.service.CustomerService;
import com.maria.ass1.dao.CustomerDAO;
import com.maria.ass1.model.order.Order;
import com.maria.ass1.model.user.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.List;
import java.util.Set;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("api/customers")

public class CustomerController {
@Autowired
private final CustomerService customerService;
    private final CommandService commandService;
    private final CustomerDAO customerDAO;


    public CustomerController(CustomerService userService, CustomerService customerService, CommandService commandService, CustomerDAO customerDAO) {
        this.customerService = customerService;
        this.commandService = commandService;
        this.customerDAO = customerDAO;
    }
    @PostMapping()
    public ResponseEntity<?> saveCustomer( @RequestBody @Valid CustomerService customerDto) {
        customerDAO.findByName(customerDto.getCustomerById(0L).getName());
        try {
            return new ResponseEntity<>(customerService.saveCustomer(customerDto), HttpStatus.CREATED);


        } catch (Throwable e) {
            return new ResponseEntity<>("Username is already used.", HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping
    public ResponseEntity<List<Customer>> getAllCustomers() {
        return new ResponseEntity<>(customerService.getAllCustomers(),HttpStatus.OK);
    }
    @GetMapping("{id}")
    public ResponseEntity<Customer> getCustomerById( @PathVariable("id")   Long customerId){
        return new ResponseEntity<>(customerService.getCustomerById(customerId), HttpStatus.OK);
    }
    @PutMapping()
    public ResponseEntity<Customer> updateCustomer( @RequestBody CustomerService customerDto){
        return new ResponseEntity<>(customerService.updateCustomer(customerDto), HttpStatus.OK);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable("id") Long id){
        //delete customer from database
        List<Order>commands=commandService.getAllCommands();
        for(Order command:commands){
            if(command.getClient().getId().equals(id)){
                commandService.deleteCommand(command.getIdCustomer());
            }
        }
        customerService.deleteCustomer(id);
        return new ResponseEntity<>("Customer deleted successfully.", HttpStatus.OK);
    }
    @PostMapping("add/{idCustomer}/{idItem}")
    public ResponseEntity<String> addToMyFavoriteList(@PathVariable Long idCustomer, @PathVariable Long idItem ) {
        customerService.addMyFavoriteList(idCustomer,idItem);
        return new ResponseEntity<>("Item added successfully", HttpStatus.OK);
    }

    @DeleteMapping("del/{idCustomer}/{idItem}")
    public ResponseEntity<String> removeToMyFavoriteList(@PathVariable Long idCustomer, @PathVariable Long idItem ) {
        customerService.removeMyFavoriteList(idCustomer,idItem);
        return new ResponseEntity<>("Item removed successfully.", HttpStatus.OK);
    }
    @GetMapping("myFv/{idCustomer}")
    public ResponseEntity<Set> listMyFavoriteList(@PathVariable("idCustomer") Long idCustomer) {
        customerDAO.findComnad(idCustomer);
        return new ResponseEntity<>( customerService.listMyFavoriteList(idCustomer),HttpStatus.OK);
    }
    @GetMapping("report/{id}")
    public ResponseEntity<String> createReportFav(@PathVariable("id") Long id) {
        customerService.createReportFav(id);
        return new ResponseEntity<>("Report created",HttpStatus.OK);
    }

    }

