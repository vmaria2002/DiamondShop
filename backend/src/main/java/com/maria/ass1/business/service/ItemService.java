package com.maria.ass1.business.service;

import com.maria.ass1.model.products.Product;

import com.maria.ass1.model.products.Type;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public interface ItemService {
    Product saveItem(Product itemDto);
    List<Product> getAllItems();
    Product getItemById(Long id);
    Product updateItem(Product itemDto);
    void deleteItem(Long id);
    List<Product>filterSize(Type type,Integer size,List<Product> items);
    List<Product>filterMaterial(Type type,String material,List<Product> items);

    List<Product> orderAsc(Type type);

    String exportItems(Double minPrice, Double maxPrice, Type type);

    List<Product> getItemsByType(String type);
    void createReport();

    }
