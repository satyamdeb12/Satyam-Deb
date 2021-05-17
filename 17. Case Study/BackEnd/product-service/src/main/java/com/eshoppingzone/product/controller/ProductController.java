package com.eshoppingzone.product.controller;


import com.eshoppingzone.product.models.Product;
import com.eshoppingzone.product.service.ProductService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
@Slf4j
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/add")
    @ApiOperation(value = "Add a new Product", notes = "Provide all the details of the product to add it to the database.", response = Product.class)
    public ResponseEntity<Product> addProduct(@RequestBody Product product){
        log.info("addProduct method of ProductController is called.");
        Product newProduct = productService.addProduct(product);
        return new ResponseEntity<>(newProduct, HttpStatus.CREATED);
    }


    @GetMapping("/find/{id}")
    @ApiOperation(value = "Find Product by Id", notes = "Provide the id in the url to and send the GET request.", response = Product.class)
    public ResponseEntity<Product> getProductById(@PathVariable("id") String id){
        log.info("getProductById method of ProductController is called.");
        Product product = productService.findProductById(id);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @GetMapping("/category/{category}")
    @ApiOperation(value = "Find Products by a particular category", notes = "Provide the category in the url to and send the GET request.", response = Product.class)
    public ResponseEntity<List<Product>> getProductsByCategory(@PathVariable("category") String category){
        log.info("getProductsByCategory method of ProductController is called.");
        List<Product> productsByCategory = productService.findProductByCategory(category);
        return new ResponseEntity<>(productsByCategory, HttpStatus.OK);
    }
    @GetMapping("/seller/{seller}")
    @ApiOperation(value = "Find Products from a particular seller.", notes = "Provide the seller name in the url to and send the GET request.", response = Product.class)
    public ResponseEntity<List<Product>> getProductsBySeller(@PathVariable("seller") String seller){
        log.info("getProductsBySeller method of ProductController is called.");
        List<Product> productsBySeller = productService.findProductBySeller(seller);
        return new ResponseEntity<>(productsBySeller, HttpStatus.OK);
    }

    @PutMapping("/update")
    @ApiOperation(value = "Update a Product", notes = "Provide the product details in thr request body to update it.", response = Product.class)
    public ResponseEntity<Product> updateProduct(@RequestBody Product product){
        log.info("updateProduct method of ProductController is called.");
        Product updatedProduct = productService.updateProduct(product);
        return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    @ApiOperation(value = "Delete a Product", notes = "Provide the product id in the url to delete it.", response = Product.class)
    public ResponseEntity<?> deleteProduct(@PathVariable("id") String id) {
        log.info("deleteProduct method of ProductController is called.");
        productService.deleteProduct(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}

