package com.boot.service;

import com.boot.dto.Customer;

public interface CustomerService {

    public Customer saveCustomer(Customer customer);

    public Customer getCustomer(Long id);

    public Customer updateCustomer(Customer customer);

}
