package com.ing.api.dto;

public class Response {
    private String data;
    private boolean success;

    public Response() {
        super();
    }

    public Response(String data, boolean success) {
        this.data = data;
        this.success = success;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

}
