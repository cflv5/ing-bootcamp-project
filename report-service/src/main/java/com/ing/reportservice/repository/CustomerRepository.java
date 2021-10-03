package com.ing.reportservice.repository;

import com.ing.reportservice.model.Customer;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {
    Customer findBySsn(String ssn);
}
