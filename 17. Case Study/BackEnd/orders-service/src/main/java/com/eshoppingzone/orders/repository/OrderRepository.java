package com.eshoppingzone.orders.repository;

import com.eshoppingzone.orders.models.Orders;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface OrderRepository extends MongoRepository<Orders, String> {

    List<Orders> findByUsername(String username);

    List<Orders> findBySeller(String seller);
}
