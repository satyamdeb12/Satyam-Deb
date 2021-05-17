package com.eshoppingzone.orders.controller;

import com.eshoppingzone.orders.models.Orders;
import com.eshoppingzone.orders.service.OrderService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
@Slf4j
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("/add")
    @ApiOperation(value = "Add a new product orders.",
            notes = "Provide the order details in thr=e request body.",
            response = Orders.class)
    public Orders addToOrders(@RequestBody Orders orders){
        log.info("addToOrders method of OrderController is called.");
        return orderService.addToOrders(orders);
    }
    @GetMapping("/get/{username}")
    @ApiOperation(value = "Get orders of a particular user",
            notes = "Provide the username in the url.",
            response = Orders.class)
    public List<Orders> fetchOrdersProducts(@PathVariable("username") String username){
        log.info("fetchOrdersProducts method of OrderController is called.");
        return orderService.fetchOrdersProducts(username);
    }

    @GetMapping("/get/seller/{seller}")
    @ApiOperation(value = "Get orders of a particular seller.",
            notes = "Provide the order seller username in the url.",
            response = Orders.class)
    public List<Orders> fetchOrdersProductsBySeller(@PathVariable("seller") String seller){
        log.info("fetchOrdersProductsBySeller method of OrderController is called.");
        return orderService.fetchOrdersProductsBySeller(seller);
    }
    @PutMapping("/update")
    @ApiOperation(value = "Update a particular order",
            notes = "Provide the updated order details in the request body.",
            response = Orders.class)
    public Orders updateOrder(@RequestBody Orders order){
        log.info("updateOrder method of OrderController is called.");
        return orderService.updateOrder(order);
    }
}
