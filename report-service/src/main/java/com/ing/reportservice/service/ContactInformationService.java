package com.ing.reportservice.service;

import com.ing.reportservice.model.ContactInformation;
import com.ing.reportservice.repository.ContactInformationRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactInformationService implements InformationService{
    @Autowired
    private ContactInformationRepository contactInformationRepository;

    @Override
    public void save(ContactInformation contactInformation) {
        contactInformationRepository.save(contactInformation);
    }
    
}
