package com.ing.citizenapi.external.dto;

import com.ing.citizenapi.dto.Citizen;
import com.ing.citizenapi.dto.Request;

public class PopulationServiceRequest extends Request<Citizen> {
    private String apiKey;

    public PopulationServiceRequest(Citizen data, String apiKey) {
        super(data);
        this.apiKey = apiKey;
    }

    public String getApiKey() {
        return apiKey;
    }

}
