package com.eshoppingzone.address.controller;

import com.eshoppingzone.address.models.Address;
import com.eshoppingzone.address.models.DeleteResponse;
import com.eshoppingzone.address.service.AddressService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/address")
@Slf4j
public class AddressController {
    @Autowired
    private AddressService addressService;

    @PostMapping("/add")
    @ApiOperation(value = "Add a new address.",
            notes = "Provide the address details in the request body.",
            response = Address.class)
    public Address addAddress(@RequestBody Address address){
        log.info("addAddress method of AddressController is called.");
        return addressService.addAddress(address);
    }

    @PutMapping("/update")
    @ApiOperation(value = "Update a particular address",
            notes = "Provide the updated address details in the request body.",
            response = Address.class)
    public Address updateAddress(@RequestBody Address address){
        log.info("updateAddress method of AddressController is called.");
        return addressService.updateAddress(address);
    }

    @GetMapping("/get/{username}")
    @ApiOperation(value = "Get all address of a particular user.",
            notes = "Provide the username in the url.",
            response = Address.class)
    public List<Address> getAddressByUsername(@PathVariable("username") String username){
        log.info("getAddressByUsername method of AddressController is called.");
        return addressService.getAddressByUsername(username);
    }

    @DeleteMapping("/delete/{id}")
    @ApiOperation(value = "Remove a particular address",
            notes = "Provide the address id in the url.",
            response = Address.class)
    public DeleteResponse deleteAddressById(@PathVariable("id") String id){
        log.info("deleteAddressById method of AddressController is called.");
        return addressService.deleteById(id);
    }
}
