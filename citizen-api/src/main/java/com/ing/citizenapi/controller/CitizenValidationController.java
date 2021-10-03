package com.ing.citizenapi.controller;

import javax.validation.Valid;

import com.ing.citizenapi.dto.Citizen;
import com.ing.citizenapi.dto.ServiceValidationRequest;
import com.ing.citizenapi.dto.ValidationResponse;
import com.ing.citizenapi.service.ValidationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/citizen")
public class CitizenValidationController {
    @Autowired
    private ValidationService<Citizen> citizenValidationService;

    @PostMapping
    @RequestMapping("/validate")
    public ResponseEntity<ValidationResponse> validate(@Valid @RequestBody ServiceValidationRequest request) {
        int responseCode = citizenValidationService.validate(request.getData());

        return ResponseEntity.status(200).body(ValidationResponse.of(responseCode));
    }
}
