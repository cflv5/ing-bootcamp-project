package com.ing.citizenapi.service;

import com.ing.citizenapi.dto.Citizen;
import com.ing.citizenapi.external.dto.PopulationServiceRequest;
import com.ing.citizenapi.external.dto.PopulationServiceResponse;
import com.ing.citizenapi.external.interfaces.PopulationOfficeService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class CitizenValidationService implements ValidationService<Citizen> {
    @Autowired
    private PopulationOfficeService populationOfficeService;

    @Value("${populationService.authKey}")
    private String authKey;

    private static final Logger LOGGER = LoggerFactory.getLogger(CitizenValidationService.class);

    @Override
    public int validate(Citizen citizen) {
        PopulationServiceResponse response = populationOfficeService
                .validate(new PopulationServiceRequest(citizen, authKey));

        if (!response.isSuccess()) {
            LOGGER.info(response.getMessage());
        }

        return response.getReturnCode();
    }

}
