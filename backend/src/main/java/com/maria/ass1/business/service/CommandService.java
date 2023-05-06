package com.maria.ass1.business.service;

import com.maria.ass1.model.order.Order;
import com.maria.ass1.model.products.Product;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface CommandService {
    Order saveCommand(Long idItem, Long idCustomer);
    List<Order> getAllCommands();
    Order getCommandById(Long id);
    Order updateCommand(Order command);
    void deleteCommand(Long id);
    void decreaseCantity(Long idCommand,Long idItem);
    double calculatePrice(Long id);
    List<Product>getItemsCommand(Long id, List<Integer>cantity);
    List<Product>getCommandItems(Long id);
    int numberOfAppearances(Long id);
    String finishCommand(Long id);
    void changed(Long id);
    List<Integer> getCantity(Long id);
    List<String> itemsInADay(int month, int day, int year );
    void createReportItem(int month, int day, int year);
}