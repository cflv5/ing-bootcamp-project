package com.ing.reportservice.service;

import com.ing.reportservice.model.ContactInformation;

import org.springframework.stereotype.Service;

@Service
public interface InformationService {
    void save(ContactInformation contactInformation);
}
