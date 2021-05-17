package com.eshoppingzone.cart.repository;

import com.eshoppingzone.cart.models.Cart;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CartRepository extends MongoRepository<Cart, String> {

    List<Cart> findByUsername(String username);

    void deleteCartByCartId(String cartId);
}
