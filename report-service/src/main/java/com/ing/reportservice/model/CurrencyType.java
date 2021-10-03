package com.ing.reportservice.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum CurrencyType {
    @JsonProperty("Türk Lirası")
    TRY("Türk Lirası"), 
    
    @JsonProperty("Amerikan Doları") 
    USD("Amerikan Doları"), 
    
    @JsonProperty("Euro")
    EUR("Euro");
    
    private String name;

    CurrencyType() {
        name = "";
    }

	CurrencyType(String name) {
		this.name = name;
	}

    public String getName() {
        return name;
    }
}
