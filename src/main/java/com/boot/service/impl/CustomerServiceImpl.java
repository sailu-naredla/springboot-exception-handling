package com.boot.service.impl;

import com.boot.dto.Customer;
import com.boot.entity.CustomerEntity;
import com.boot.exception.BadRequestException;
import com.boot.exception.NoSuchElementFoundException;
import com.boot.exception.ResourceNotFoundException;
import com.boot.repository.CustomerRepository;
import com.boot.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customer saveCustomer(Customer customer) {

        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setName(customer.getName());
        customerEntity.setLocation(customer.getLocation());
        customerRepository.save(customerEntity);

        customer.setId(customerEntity.getId());
        return customer;
    }

    @Override
    public Customer getCustomer(Long id) {
        Optional<CustomerEntity> customerEntity = customerRepository.findById(id);
        if(customerEntity.isPresent()){
            Customer customer = new Customer();
            customer.setId(customerEntity.get().getId());
            customer.setName(customerEntity.get().getName());
            customer.setLocation(customerEntity.get().getLocation());
            return customer;
        }else{
            throw new NoSuchElementFoundException("Customer Not Found With ID "+id);
        }
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        if(null != customer && null != customer.getId()){
            if(null == customer.getLocation() || customer.getLocation().isBlank()){
                throw new BadRequestException("Customer location is missed");
            }
            Optional<CustomerEntity> customerEntity = customerRepository.findById(customer.getId());
            if(customerEntity.isPresent()){
                CustomerEntity newCustomerEntity = customerEntity.get();
                newCustomerEntity.setLocation(customer.getLocation());
                customerRepository.save(newCustomerEntity);
                return customer;
            }else{
                throw new ResourceNotFoundException("Customer Not Found");
            }
        }else{
            throw  new NoSuchElementFoundException("Customer id is missed");
        }
    }
}
