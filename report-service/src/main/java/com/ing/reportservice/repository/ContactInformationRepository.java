package com.ing.reportservice.repository;

import com.ing.reportservice.model.ContactInformation;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactInformationRepository extends CrudRepository<ContactInformation, Long> {
}
