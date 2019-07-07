package com.spring.demo.services;

import com.spring.demo.entity.Customer;
import com.spring.demo.errors.RestServiceException;
import com.spring.demo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customer){

        this.customerRepository = customer;
    }

    public Customer getCustomer(Long id){

        Optional<Customer> customerData = customerRepository.findById(id);
        if(customerData.isPresent()){

            return customerData.get();
        }else{

            throw new RestServiceException("Customer not found in database");
        }
    }
}
