package com.ing.citizenapi.external.interfaces;

import com.ing.citizenapi.external.dto.PopulationServiceRequest;
import com.ing.citizenapi.external.dto.PopulationServiceResponse;

import org.springframework.stereotype.Service;

@Service
public interface PopulationOfficeService {
    PopulationServiceResponse validate(PopulationServiceRequest request);
}
