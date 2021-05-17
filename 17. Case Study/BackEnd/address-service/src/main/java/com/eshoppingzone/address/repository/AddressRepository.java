package com.eshoppingzone.address.repository;

import com.eshoppingzone.address.models.Address;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface AddressRepository extends MongoRepository<Address, String> {
    List<Address> findByUsername(String username);

    void deleteAddressById(String id);
}
