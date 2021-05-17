package com.eshoppingzone.cart.controller;

import com.eshoppingzone.cart.models.Cart;
import com.eshoppingzone.cart.models.DeleteResponse;
import com.eshoppingzone.cart.service.CartService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private CartService cartService;

    @PostMapping("/add")
    @ApiOperation(value = "Add a new Product to the cart.",
            notes = "Provide all the details of the product to add it to the cart.",
            response = Cart.class)
    public Cart addToCart(@RequestBody Cart cart){
        return cartService.addToCart(cart);
    }
    @GetMapping("/get/{username}")
    @ApiOperation(value = "Get all the products of a user from the cart.",
            notes = "Provide the username in the url to fetch the products in his/her cart.",
            response = Cart.class)
    public List<Cart> fetchCartProducts(@PathVariable("username") String username){
        return cartService.fetchCartProducts(username);
    }
    @DeleteMapping("delete/{cartId}")
    @ApiOperation(value = "Remove a product from the cart.",
            notes = "Provide the cart in the url to remove it from in his/her cart.",
            response = Cart.class)
    public DeleteResponse deleteByCartId(@PathVariable("cartId") String cartId ){
       return cartService.deleteByCartId(cartId);
    }

    
}
