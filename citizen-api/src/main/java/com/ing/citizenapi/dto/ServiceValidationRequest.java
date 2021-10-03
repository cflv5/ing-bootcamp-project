package com.ing.citizenapi.dto;

import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.validation.annotation.Validated;

@Validated
public class ServiceValidationRequest extends Request<Citizen>{
    public ServiceValidationRequest(@Valid @JsonProperty("data") Citizen citizen) {
        super(citizen);
    }
}
