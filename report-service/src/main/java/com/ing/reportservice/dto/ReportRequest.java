package com.ing.reportservice.dto;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.validation.annotation.Validated;

@Validated
public class ReportRequest {
    @NotNull
    private final CustomerDto customer;

    public ReportRequest(@JsonProperty("customer") @NotNull CustomerDto customer) {
        this.customer = customer;
    }

    public CustomerDto getCustomer() {
        return customer;
    }

}
