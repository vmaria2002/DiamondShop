package com.maria.ass1.business.service;


import com.maria.ass1.exception.ResourceNotFoundException;
import com.maria.ass1.model.products.Product;
import com.maria.ass1.model.products.Type;
import com.maria.ass1.repository.OrderRepository;
import com.maria.ass1.repository.ProdusRepoditory;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.swing.*;

import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;


@Service
public class ItemServiceImpl implements ItemService {
    private final ProdusRepoditory itemRepository;
    private final OrderRepository commandRepository;

    public ItemServiceImpl(ProdusRepoditory itemRepository, OrderRepository commandRepository) {
        this.itemRepository = itemRepository;
        this.commandRepository = commandRepository;
    }


    @Override
    public Product saveItem(Product itemDto) throws ConstraintViolationException {
        Product item=new Product();
        item.setType(itemDto.getType());
        item.setMaterial(itemDto.getMaterial());
        item.setPrice(itemDto.getPrice());
        item.setDescription(itemDto.getDescription());
        item.setSize(1);
        item.setName(itemDto.getName());
        item.setAvailability(itemDto.getAvailability());

        return itemRepository.save(item);
    }


    @Override
    public List<Product> getAllItems() {
        return itemRepository.findAll();
    }


    @Override
    public Product getItemById(Long id) {
        return itemRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Item","Id",id, HttpStatus.NOT_FOUND));
    }


    @Override
    public Product updateItem(Product itemDto) {
        Product item=new Product();
        item.setIdItem(itemDto.getIdItem());
        item.setType(itemDto.getType());
        item.setMaterial(itemDto.getMaterial());
        item.setPrice(itemDto.getPrice());
        item.setDescription(itemDto.getDescription());
        item.setSize(itemDto.getSize());
        item.setName(itemDto.getName());
        item.setNameImg("./images/products/bratara0.jpg");
        Product existingItem=itemRepository.findById(item.getIdItem()).orElseThrow(()->new ResourceNotFoundException("Item","Id",item.getIdItem(),HttpStatus.NOT_FOUND));
        if (item.getAvailability() != null) {
            existingItem.setAvailability(item.getAvailability());
        }
        if(item.getDescription()!=null){
            existingItem.setDescription(item.getDescription());
        }
        if(item.getMaterial()!=null){
            existingItem.setMaterial(item.getMaterial());
        }

        if(item.getSize()!=null){
            existingItem.setSize(item.getSize());
        }
        if(item.getType()!=null){
            existingItem.setType(item.getType());
        }
        if(item.getName()!=null){
            existingItem.setName(item.getName());
        }
        itemRepository.save(existingItem);
        return existingItem;
    }
    @Override
    @Transactional
    public void deleteItem(Long id) {
        itemRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Item","Id",id,HttpStatus.NOT_FOUND));
        Long idCommand=0L;
        List<Long>idCommands=new ArrayList<>();

        if(idCommands.size()!=0) {
            for (Long commandId : idCommands) {
                commandRepository.deleteById(commandId);
            }
        }
        itemRepository.deleteById(id);
    }


    public List<Product> filterPrice(Type type, Double priceMin, Double priceMax, List<Product> items) {
        List<Product>resultFilter=new ArrayList<>();
        for(Product item:items) {
            if(item.getType().equals(type)){
                if(item.getPrice()>=priceMin && item.getPrice()<=priceMax){
                    resultFilter.add(item);
                }
            }
        }
        return  resultFilter;
    }

    public List<Product> filterAvailability(Type type, Boolean availability,List<Product> items) {
        List<Product>resultFilter=new ArrayList<>();
        for(Product item:items) {
            if(item.getType().equals(type)){
                if(item.getAvailability().equals(availability)){
                    resultFilter.add(item);
                }
            }
        }
        return  resultFilter;
    }


    @Override
    public List<Product> filterSize(Type type, Integer size,List<Product> items) {
        List<Product>resultFilter=new ArrayList<>();
        for(Product item:items) {
            if(item.getType().equals(type)){
                if(item.getSize()!=null && item.getSize().equals(size)){
                    resultFilter.add(item);
                }
            }
        }
        return  resultFilter;
    }


    @Override
    public List<Product> filterMaterial(Type type, String material,List<Product> items) {
        List<Product>resultFilter=new ArrayList<>();
        for(Product item:items) {
            if(item.getType().equals(type)){
                if(item.getMaterial().equals(material)){
                    resultFilter.add(item);
                }
            }
        }
        return  resultFilter;
    }



    @Override
    public List<Product> orderAsc(Type type) {
        List<Product> items=itemRepository.findAll();
        List<Product>result=new ArrayList<>();
        for(Product item:items){
            if(item.getType().equals(type)){
                result.add(item);
            }
        }
        Collections.sort(result);
        return  result;
    }

    public List<Product> orderDesc(Type type) {
        List<Product> items=itemRepository.findAll();
        List<Product>result=new ArrayList<>();
        Collections.sort(items);
        for(int i=items.size()-1;i >=0;i--){
            if(items.get(i).getType().equals(type)){
                result.add(items.get(i));
            }
        }
        return  result;
    }

    @Override
    public String exportItems(Double minPrice, Double maxPrice, Type type) {
        List<Product>items=getAllItems();
        items=filterPrice(type,minPrice,maxPrice,items);
        String nameFile="./"+type.toString()+".xls";
        String[] tableColumn = {"Item's name", "Price", "Type"};
        String[][] tableData = new String[items.size()][tableColumn.length];
        Product item;

            for(int i=0;i<items.size();i++){
              item=items.get(i);
              tableData[i][0]=item.getName();
              tableData[i][2]=item.getType().toString();

            }
        JTable jTable = new JTable(tableData, tableColumn);


        return null;
    }


    public Product exportMaxItem(String type) {
        int max=0;
        //System.out.println(type.toLowerCase());
        Type newType=Type.parseType(type.toLowerCase());
        //System.out.println(newType);
        Product res=new Product();
        List<Product> items=new ArrayList<>();
        for(Product item : itemRepository.findAll()){
            if(item.getType().equals(newType)){
                items.add(item);
            }
        }
        for(Product item:items){
            OrderRepository orderRepository = null;
            List<Product>orderItemList=orderRepository.findOrderItemByItem(itemRepository.findById(item.getIdItem()).get());
            if(orderItemList.size()>max) {
                max=orderItemList.size();
                res=item;
            }
        }
        return res;

    }

    @Override
    public List<Product> getItemsByType(String type) {
        Type newType=Type.parseType(type.toLowerCase());
        List<Product> items=new ArrayList<>();
        for(Product item:itemRepository.findAll()){
            if(item.getType().equals(newType)){
                items.add(item);
            }
        }
        return items;
    }

    @Override
    public void createReport() {
        List<Product>items=new ArrayList<>();
        List<Integer>ap=new ArrayList<>();
        List<Product>orderItemList;
        Product item;
        String nameFile="./ItemMax.json";
        System.out.println(Type.RING.toString());
        item=exportMaxItem(Type.RING.toString());
        if(item.getIdItem()!=null){
            items.add(item);
            orderItemList=commandRepository.findOrderItemByItem(itemRepository.findById(item.getIdItem()).get());
            ap.add(orderItemList.size());

        }


        item=exportMaxItem(Type.BRACELET.toString());
        if(item.getIdItem()!=null){
            items.add(item);
            orderItemList=commandRepository.findOrderItemByItem(itemRepository.findById(item.getIdItem()).get());
            ap.add(orderItemList.size());

        }



        item=exportMaxItem(Type.EARRINGS.toString());
        if(item.getIdItem()!=null){
            items.add(item);
            orderItemList=commandRepository.findOrderItemByItem(itemRepository.findById(item.getIdItem()).get());
            ap.add(orderItemList.size());
        }



        item=exportMaxItem(Type.NECKLACE.toString());
        if (item.getIdItem()!=null) {
            items.add(item);
            orderItemList=commandRepository.findOrderItemByItem(itemRepository.findById(item.getIdItem()).get());
            ap.add(orderItemList.size());
        }



        item=exportMaxItem(Type.CHARM.toString());
        if(item.getIdItem()!=null){
            items.add(item);
            orderItemList=commandRepository.findOrderItemByItem(itemRepository.findById(item.getIdItem()).get());
            ap.add(orderItemList.size());
        }



    }

}
