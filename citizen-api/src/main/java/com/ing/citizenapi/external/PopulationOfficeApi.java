package com.ing.citizenapi.external;

import com.ing.citizenapi.external.dto.PopulationServiceRequest;
import com.ing.citizenapi.external.dto.PopulationServiceResponse;
import com.ing.citizenapi.external.interfaces.PopulationOfficeService;

import org.springframework.stereotype.Service;

@Service
public class PopulationOfficeApi implements PopulationOfficeService {
    @Override
    public PopulationServiceResponse validate(PopulationServiceRequest request) {
        return new PopulationServiceResponse(true, "citizen validated", 10);
    }

}
