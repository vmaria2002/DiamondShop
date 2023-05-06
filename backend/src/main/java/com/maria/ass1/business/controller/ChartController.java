package com.maria.ass1.business.controller;

import com.maria.ass1.business.factory.*;
import com.maria.ass1.business.service.CustomerService;
import com.maria.ass1.model.decorator.chart.ChartColor;
import com.maria.ass1.model.decorator.chart.GreenChartDecorator;
import com.maria.ass1.model.decorator.chart.RedChartDecorator;
import com.maria.ass1.model.user.User;
import org.springframework.web.bind.annotation.*;

import static com.maria.ass1.model.decorator.chart.ChartColor.GREEN;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping(path = "/api/chart")
public class ChartController {
    private final CustomerService userService;

    public ChartController(CustomerService userService) {
        this.userService = userService;
    }

    @GetMapping(path = "/{type}/{id}")
    public User getChart(@PathVariable String type, @PathVariable Long id) throws Throwable {
        System.out.println("Type:"+type);
        User myUser= userService.getUser(id);
        User user1 = null;
        if(type.equals("bracelet")) {
            BraceletProduct braceletProduct = new BraceletProduct(myUser);
            user1 = braceletProduct.generateChart(type);
        }
        if(type.equals("charm")) {
            NecklageProduct necklageProduct = new NecklageProduct(myUser);
            user1 = necklageProduct.generateChart(type);
            System.out.println((user1));
        }
        if(type.equals("earring")) {
            EarringsProduct earringsProduct = new EarringsProduct(myUser);
            user1 = earringsProduct.generateChart(type);
            System.out.println((user1));
        }

        if(type.equals("necklage")) {
            NecklageProduct necklageProduct = new NecklageProduct(myUser);
            user1 = necklageProduct.generateChart(type);
            System.out.println((user1));
        }
        if(type.equals("ring")) {
            RingProduct ringProduct = new RingProduct(myUser);
            user1 = ringProduct.generateChart(type);
            System.out.println((user1));
        }
        return user1;

    }

    @GetMapping(path = "/{type}/{size}/{color}{id}")
    public void getChart(@PathVariable String type, @PathVariable Long id, @PathVariable Long ize, String colour) throws Throwable {

        User myUser = userService.getUser(id);
        User user1 = null;

        if (colour.equals("red")) {
            RedChartDecorator redChartDecorator = new RedChartDecorator();
            user1 = redChartDecorator.generateChart(type);
            System.out.println((user1));
        }
        if (colour.equals("green")) {
            GreenChartDecorator greenChartDecorator = new GreenChartDecorator();
            user1 = greenChartDecorator.generateChart(type);
            System.out.println((user1));
        }
    }

}
