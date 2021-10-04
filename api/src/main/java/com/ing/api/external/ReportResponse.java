package com.ing.api.external;

public class ReportResponse {
    private String message;
    private boolean success;

    public ReportResponse() {
        super();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    @Override
    public String toString() {
        return "ReportResponse [message=" + message + ", success=" + success + "]";
    }

}
