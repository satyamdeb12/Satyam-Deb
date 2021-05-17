package com.eshoppingzone.orders.service;

import com.eshoppingzone.orders.models.Orders;
import com.eshoppingzone.orders.repository.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public Orders addToOrders(Orders orders) {
        log.info("addToOrders method of OrderService is called.");
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        orders.setOrderedOn(formatter.format(date));
        orders.setOrderStatus("paid");
       return orderRepository.save(orders);
    }

    public List<Orders> fetchOrdersProducts(String username) {
        log.info("fetchOrdersProducts method of OrderService is called.");
        return orderRepository.findByUsername(username);
    }

    public List<Orders> fetchOrdersProductsBySeller(String seller) {
        log.info("fetchOrdersProductsBySeller method of OrderService is called.");
        return orderRepository.findBySeller(seller);
    }

    public Orders updateOrder(Orders order) {
        log.info("updateOrder method of OrderService is called.");
        return orderRepository.save(order);
    }
}
