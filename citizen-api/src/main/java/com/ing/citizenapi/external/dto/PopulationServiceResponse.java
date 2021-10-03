package com.ing.citizenapi.external.dto;

import com.ing.citizenapi.dto.Response;

public class PopulationServiceResponse extends Response {
    private int returnCode;

    public PopulationServiceResponse(boolean success, String message, int returnCode) {
        super(success, message);
        this.returnCode = returnCode;
    }

    public int getReturnCode() {
        return returnCode;
    }
}
