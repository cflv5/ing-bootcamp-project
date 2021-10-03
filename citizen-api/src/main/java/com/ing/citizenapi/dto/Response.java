package com.ing.citizenapi.dto;

public abstract class Response {
    private boolean success;
    private String message;

    protected Response(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }
}
