package com.ing.reportservice.service;

import com.ing.reportservice.model.Customer;
import com.ing.reportservice.repository.CustomerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReportApiCustomerService implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customer findCustomerBySsn(String ssn) {
        return customerRepository.findBySsn(ssn);
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);        
    }
    
}
