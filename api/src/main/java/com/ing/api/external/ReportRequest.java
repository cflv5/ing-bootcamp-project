package com.ing.api.external;

import com.ing.api.dto.Request;

public class ReportRequest {
    private Request customer;

    public ReportRequest() {
        super();
    }

    public ReportRequest(Request customer) {
        this.customer = customer;
    }

    public Request getCustomer() {
        return customer;
    }

    public void setCustomer(Request customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "ReportRequest [customer=" + customer + "]";
    }

}
