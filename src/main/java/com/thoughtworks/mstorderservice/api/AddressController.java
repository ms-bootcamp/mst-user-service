package com.thoughtworks.mstorderservice.api;

import com.thoughtworks.mstorderservice.entity.Address;
import com.thoughtworks.mstorderservice.service.AddressService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/address")
public class AddressController {

    @Autowired
    AddressService addressService;

    @GetMapping(value = "/{user_id}")
    @ResponseStatus(HttpStatus.OK)
    public List<Address> getAddressByUser(@PathVariable("user_id") String userId) {

        return addressService.findByUserId(userId);
    }
}
