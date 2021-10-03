package com.ing.citizenapi.dto;

public class ValidationResponse extends Response {
    public ValidationResponse(boolean success, String message) {
        super(success, message);
    }

    public static ValidationResponse of(int statusCode) {
        ValidationResponse response = null;
        switch (statusCode) {
            case 10:
                response = new ValidationResponse(true, "Citizen successfully validated");
                break;
            case 21:
                response = new ValidationResponse(false, "No citizen found with provided SSN");
                break;
            default:
                response = new ValidationResponse(false, "Unknown error occured");
        }
        return response;
    }
}
