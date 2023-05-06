package com.maria.ass1.business.controller;

import com.maria.ass1.dao.CustomerDAO;
import com.maria.ass1.dao.OrderDAO;
import com.maria.ass1.dao.ProdusDAO;
import com.maria.ass1.dao.ShoppingCartDAO;
import com.maria.ass1.model.builder.OrderBuilder;
import com.maria.ass1.model.cart.Cart;
import com.maria.ass1.model.cart.ShoppingCart;
import com.maria.ass1.model.decorator.cart.*;
import com.maria.ass1.model.order.Order;
import com.maria.ass1.model.products.Product;
import com.maria.ass1.model.products.Type;
import com.maria.ass1.model.user.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("cart")
public class ShoppingCartController {

    @Autowired
    private ShoppingCartDAO shoppingCartDao;

    @Autowired
    private ProdusDAO produsDao;

    @Autowired
    private OrderDAO ordersDao;

    @Autowired
    private CustomerDAO customerDAO;

    @RequestMapping(value = "list/{userId}", method = RequestMethod.GET)
    public String listItems(Model model, @PathVariable int userId){

        List<ShoppingCart> shoppingCarts = shoppingCartDao.findByUserId(userId);
        return "cart/list";
    }

    @RequestMapping(value = "list/{userId}", method = RequestMethod.POST)
    public String processListItems(Model model, @RequestParam String type, @PathVariable int userId){

        List<ShoppingCart> shoppingCarts = shoppingCartDao.findByUserId(userId);
        Cart cart = null;
        String deals = "No deals";

        for(ShoppingCart shoppingCart : shoppingCarts){
            List<ShoppingCart> shoppingCartByType =null;

            if(type.equals(Type.NECKLACE)){
                shoppingCartDao.findByType(String.valueOf(Type.NECKLACE));
                cart = new LantisorCartDecorator(shoppingCart);
            }
            if(type.equals(Type.BRACELET)){
                shoppingCartDao.findByType(String.valueOf(Type.BRACELET));
                cart = new BrataraCartDecorator(shoppingCart);
            }
            if(type.equals(Type.EARRINGS)){
                shoppingCartDao.findByType(String.valueOf(Type.EARRINGS));
                cart = new CerceiCartDecorator(shoppingCart);
            }
            if(type.equals(Type.CHARM)){
                shoppingCartDao.findByType(String.valueOf(Type.CHARM));
                cart = new PandanticCarteDecorator(shoppingCart);
            }
            else{
                shoppingCartDao.findByType(String.valueOf(Type.RING));
                cart = new InelCartDecortaor(shoppingCart);
            };

            shoppingCartDao.save(shoppingCart);
        }

        return "cart/list";
    }

    @RequestMapping(value = "add/{userId}", method  = RequestMethod.GET)
    public String displayAddOrder(Model model, @PathVariable int userId){
    shoppingCartDao.findByUserId(userId);

        return "cart/add";
    }

    @RequestMapping(value = "add/{userId}", method = RequestMethod.POST)
    public String processAddOrder(@RequestParam int[] shoppingCartIds, @PathVariable int userId, Model model){

        Customer user = null;

        Optional<Customer> optionalUser = customerDAO.findById(userId);
        if(optionalUser.isPresent()){

            user = optionalUser.get();
        }

        for(int shoppingCartId : shoppingCartIds){

            String product = null;
            ShoppingCart shoppingCart = null;
            Optional<ShoppingCart> optionalShoppingCart = shoppingCartDao.findById(shoppingCartId);
            if(optionalShoppingCart.isPresent()){

                shoppingCart = optionalShoppingCart.get();
                product = shoppingCart.getProduct();
            }

            Order order = new OrderBuilder()
                    .setUsername(user.getUsername())
                    .setUser(user)
                    .setProduct(product)
                    .setStatus("Pending")
                    .build();

            order.setProduct(order.getProduct());
            ordersDao.save(order);
            shoppingCartDao.delete(shoppingCart);
        }
        return "message";
    }

    @RequestMapping(value = "remove/{userId}", method  = RequestMethod.GET)
    public String displayRemoveItems(Model model, @PathVariable int userId){
        shoppingCartDao.findByUserId(userId);
        return "cart/remove";
    }

    @RequestMapping(value = "remove/{userId}", method = RequestMethod.POST)
    public String processRemoveItems(@RequestParam int[] shoppingCartIds, @PathVariable int userId, Model model){

        for(int shoppingCartId : shoppingCartIds){

            ShoppingCart shoppingCart = null;
            Optional<ShoppingCart> optionalShoppingCart = shoppingCartDao.findById(shoppingCartId);
            if(optionalShoppingCart.isPresent()){

                shoppingCart = optionalShoppingCart.get();
            }

            shoppingCartDao.delete(shoppingCart);
        }
        return "message";
    }
}