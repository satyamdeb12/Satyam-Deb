package com.eshoppingzone.product.service;


import com.eshoppingzone.product.exception.ProductNotFoundException;
import com.eshoppingzone.product.models.Product;
import com.eshoppingzone.product.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@Slf4j
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product addProduct(Product product){
        log.info("addProduct method of ProductService is called.");
        return productRepository.save(product);
    }


    public Product findProductById(String id){
        log.info("findProductById method of ProductService is called.");
        return productRepository.findProductById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product containing id "+id+" was not found"));
    }

    public List<Product> findProductByCategory(String productCategory){
        log.info("findProductByCategory method of ProductService is called.");
        return productRepository.findProductByProductCategory(productCategory);
    }

    public Product updateProduct(Product product){
        log.info("updateProduct method of ProductService is called.");
        return productRepository.save(product);
    }

    public void deleteProduct(String id){
        log.info("deleteProduct method of ProductService is called.");
        productRepository.deleteProductById(id);
    }

    public List<Product> findProductBySeller(String seller) {
        log.info("findProductBySeller method of ProductService is called.");
        return productRepository.findProductBySeller(seller);
    }
}

