package com.ing.reportservice.external.dto;

import com.ing.reportservice.dto.CustomerDto;

public class CitizenApiRequest {
    private Citizen data;

    public CitizenApiRequest(Citizen data) {
        this.data = data;
    }

    public static CitizenApiRequest of(CustomerDto customer) {
        Citizen citizen = new Citizen(customer.getSsn(), customer.getName(), customer.getSurname(),
                customer.getBirthday());
        return new CitizenApiRequest(citizen);
    }

    public Citizen getData() {
        return data;
    }

}
