package com.ing.reportservice.service;

import com.ing.reportservice.model.Customer;

import org.springframework.stereotype.Service;

@Service
public interface CustomerService {
    Customer findCustomerBySsn(String ssn);
    void save(Customer customer);
}
