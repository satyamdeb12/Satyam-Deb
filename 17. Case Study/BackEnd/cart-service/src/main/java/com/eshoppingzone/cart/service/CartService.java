package com.eshoppingzone.cart.service;

import com.eshoppingzone.cart.models.Cart;
import com.eshoppingzone.cart.models.DeleteResponse;
import com.eshoppingzone.cart.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {
    @Autowired
    private CartRepository cartRepository;

    public Cart addToCart(Cart cart) {
        return cartRepository.save(cart);
    }

    public List<Cart> fetchCartProducts(String username) {
        return cartRepository.findByUsername(username);
    }

    public DeleteResponse deleteByCartId(String cartId) {
        DeleteResponse deleteResponse = new DeleteResponse();
        deleteResponse.setProductName("Product");
        cartRepository.deleteCartByCartId(cartId);
        return deleteResponse;

    }
}
