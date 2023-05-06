package com.maria.ass1.business.controller;

import com.maria.ass1.dao.*;
import com.maria.ass1.model.builder.NotificationBuilder;
import com.maria.ass1.model.builder.ShoppingCartBuilder;
import com.maria.ass1.model.cart.ShoppingCart;
import com.maria.ass1.model.decorator.observer.Notification;
import com.maria.ass1.model.order.Order;
import com.maria.ass1.model.products.Product;
import com.maria.ass1.model.user.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("api/order")
public class OrderController {
        @Autowired
        private OrderDAO ordersDao;

        @Autowired
        private CustomerDAO userDao;

        @Autowired
        private ProdusDAO produsDao;

        @Autowired
        private NotificationDAO notificationDao;

        @Autowired
        private ShoppingCartDAO shoppingCartDao;

        @RequestMapping(value = "list/{userId}", method =  RequestMethod.GET)
        public String listOrders(Model model, @PathVariable int userId){

            Customer user = null;
            Optional<Customer> optionalUser = userDao.findById(userId);
            if(optionalUser.isPresent()){
                user = optionalUser.get();

            }

            model.addAttribute("title", "Pending Orders");
            model.addAttribute("orders", ordersDao.findAll());
            model.addAttribute("userId", userId);

            return "order/list";
        }

        @RequestMapping(value = "history/{userId}", method = RequestMethod.GET)
        public String listMyOrders(Model model, @PathVariable int userId){
            ordersDao.findByUserId(userId);
            return "order/history";
        }

        @RequestMapping(value = "history/{userId}", method = RequestMethod.POST)
        public String processListMyOrders(@RequestParam int orderId, @PathVariable int userId, @ModelAttribute Model model){

            Optional<Order> optionalOrder = ordersDao.findById(orderId);
            Order order = null;
            if(optionalOrder.isPresent()){
                order = optionalOrder.get();
            }

            ordersDao.save(order);

            return "redirect:/order/history/" + userId;
        }

        @RequestMapping(value = "add/{userId}", method  = RequestMethod.GET)
        public String displayAddOrder(Model model, @PathVariable int userId){

            Customer user = null;
            Optional<Customer> optionalUser = userDao.findById(userId);
            if(optionalUser.isPresent()){

                user = optionalUser.get();

            }
            produsDao.findAll();
            return "order/add";
        }

        @RequestMapping(value = "add/{userId}", method = RequestMethod.POST)
        public String processAddOrder(@RequestParam int[] foodIds, @PathVariable int userId, Model model){

            Customer user = null;

            for(int foodId : foodIds){

                Product product= null;
                Optional<Product> optionalProduct = produsDao.findById((long) userId);
                if(optionalProduct.isPresent()){

                    product = optionalProduct.get();
                }

                ShoppingCart shoppingCart = new ShoppingCartBuilder()
                        .setProduct(product)
                        .setUserId(userId)
                        .setPrice((int) product.getPrice())
                        .setDeals("")
                        .build();
                shoppingCartDao.save(shoppingCart);
            }

            return "message";
        }

        @RequestMapping(value = "remove/{userId}", method = RequestMethod.GET)
        public String displayRemoveOrder(Model model, @PathVariable int userId){

            Customer user = null;
            Optional<Customer> optionalUser = userDao.findById(userId);
            if(optionalUser.isPresent()){
                user = optionalUser.get();
            }


            List<Order> allORders = new ArrayList<>();
            List<Order> ordersToDisplay = new ArrayList<>();

            for(Order order : ordersDao.findAll()){
                if(!order.getStatus().equals("Payed")){
                    ordersToDisplay.add(order);
                }
            }

            return "order/remove";
        }

        @RequestMapping(value = "remove/{userId}", method = RequestMethod.POST)
        public String processRemoveOrder(@RequestParam int[] orderIds, @PathVariable int userId){

            for(int orderId : orderIds){
                Optional<Order> optionalOrder = ordersDao.findById(orderId);
                Order order = null;
                if(optionalOrder.isPresent()){
                    order = optionalOrder.get();
                }

                Customer user = null;
                Optional<Customer> optionalUser = userDao.findById(orderId);
                if(optionalUser.isPresent()) {

                    user = optionalUser.get();
                }

                String notificationMessage = "No notifications";

                if(order.getStatus().equals("Pending")){
                    order.setStatus("Shipping");
                    notificationMessage = "Comanda a fost plasata cu succes.Puteti vedea factura!";
                }


                Notification notification = new NotificationBuilder()
                        .setUser(user)
                        .setNotification(notificationMessage)
                        .build();

                order.notifyObserver(user, notification);

                ordersDao.save(order);
                notificationDao.save(notification);
            }

            return "redirect:/order/list/" + userId;
        }
}
