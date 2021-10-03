package com.ing.reportservice.external.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ing.reportservice.dto.Response;

public class CitizenApiResponse extends Response {
    public CitizenApiResponse(@JsonProperty("success") boolean success, @JsonProperty("message") String message) {
        super(success, message);
    }
}
