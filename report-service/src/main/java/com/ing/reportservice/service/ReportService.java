package com.ing.reportservice.service;

import java.util.UUID;

import com.ing.reportservice.dto.CustomerDto;
import com.ing.reportservice.model.CreditReport;

import org.springframework.stereotype.Service;

@Service
public interface ReportService {
    CreditReport createCreditReport(CustomerDto customer);
    CreditReport getCreditReport(UUID id);
}
