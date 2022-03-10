package com.boot.controller;

import com.boot.dto.Customer;
import com.boot.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/")
    public Customer saveCustomer(@RequestBody Customer customer){
        return customerService.saveCustomer(customer);
    }

    @GetMapping("/{id}")
    public Customer getCustomer(@PathVariable("id") Long id){
        return customerService.getCustomer(id);
    }

    @PutMapping("/")
    public Customer updateCustomer(@RequestBody Customer customer){
        return customerService.updateCustomer(customer);
    }
}
