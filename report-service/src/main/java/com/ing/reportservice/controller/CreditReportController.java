package com.ing.reportservice.controller;

import java.util.UUID;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ing.reportservice.dto.ReportRequest;
import com.ing.reportservice.dto.Response;
import com.ing.reportservice.model.CreditReport;
import com.ing.reportservice.service.ReportService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/credit-report")
public class CreditReportController {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private ReportService creditReportService;

    private final Logger logger = LoggerFactory.getLogger(CreditReportController.class);

    private static final ObjectMapper MAPPER= new ObjectMapper();
    
    @PostMapping
    public ResponseEntity<Response> createCreditReport(@RequestBody ReportRequest request) {
        try {
            CreditReport report = creditReportService.createCreditReport(request.getCustomer());
            rabbitTemplate.convertAndSend("report-queue", MAPPER.writeValueAsString(report));
        } catch (Exception e) {
            logger.error("Error in credit-report/", e);
            return ResponseEntity.status(500).body(new Response(false, e.getLocalizedMessage()));
        }

        return ResponseEntity.status(200).body(new Response(true,
                "Kredi raporu oluşturuluyor. Sonuç iletişim bilgileriniz üzerinden size iletilecek."));
    }

    @GetMapping
    @RequestMapping("/{id}")
    public ResponseEntity<CreditReport> getCreditReport(@PathVariable UUID id){
        CreditReport report = null;
        try {
            report = creditReportService.getCreditReport(id);
        } catch (Exception e) {
            logger.error("Error in credit-report/", e);
            return ResponseEntity.status(500).body(null);
        }

        return ResponseEntity.status(200).body(report);
    }
}
