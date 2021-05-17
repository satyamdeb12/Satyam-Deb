package com.eshoppingzone.product.repository;

import com.eshoppingzone.product.models.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends MongoRepository<Product, String> {
    Optional<Product> findProductById(String id);

    List<Product> findProductByProductCategory(String productCategory);

    void deleteProductById(String id);

    List<Product> findProductBySeller(String seller);
}
