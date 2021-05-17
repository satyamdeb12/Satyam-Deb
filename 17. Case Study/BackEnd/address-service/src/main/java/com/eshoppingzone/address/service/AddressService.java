package com.eshoppingzone.address.service;

import com.eshoppingzone.address.models.Address;
import com.eshoppingzone.address.models.DeleteResponse;
import com.eshoppingzone.address.repository.AddressRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class AddressService {
    @Autowired
    private AddressRepository addressRepository;


    public Address addAddress(Address address) {
        log.info("addAddress method of Address Service is called.");
        return addressRepository.save(address);
    }

    public Address updateAddress(Address address) {
        log.info("updateAddress method of Address Service is called.");
        return addressRepository.save(address);
    }

    public List<Address> getAddressByUsername(String username) {
        log.info("getAddressByUsername method of Address Service is called.");
        return addressRepository.findByUsername(username);
    }


    public DeleteResponse deleteById(String id) {
        log.info("deleteById method of Address Service is called.");
        addressRepository.deleteAddressById(id);
        DeleteResponse deleteResponse  = new DeleteResponse();
        deleteResponse.setMsg("Removed Address Successfully");
        return deleteResponse;
    }
}
