package com.ing.api.controller;

import java.util.List;
import java.util.UUID;

import com.ing.api.dto.Request;
import com.ing.api.dto.Response;
import com.ing.api.external.ReportRequest;
import com.ing.api.external.ReportResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

@RestController
@RequestMapping("/v1/credit-report")
public class ReportController {

    @Autowired
    private DiscoveryClient discoveryClient;

    @Value("${external.report-service.key}")
    private String authKey;

    private static final Logger LOGGER = LoggerFactory.getLogger(ReportController.class);

    @GetMapping
    @RequestMapping("/{id}")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public ResponseEntity<Response> getReport(@PathVariable UUID id) {
        Response response = new Response();

        List<ServiceInstance> instanceList = this.discoveryClient.getInstances("REPORT-SERVICE");

        String uri = instanceList.get(0).getUri().toString();
        WebClient client = WebClient.create(uri + "/credit-report/" + id.toString());

        String apiResponse = client.get().header("SERVICE-KEY", authKey).retrieve().bodyToMono(String.class).block();

        response.setData(apiResponse);
        response.setSuccess(true);

        return ResponseEntity.status(200).body(response);
    }

    @PostMapping
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public ResponseEntity<Response> createReport(@RequestBody Request request) {
        List<ServiceInstance> instanceList = this.discoveryClient.getInstances("REPORT-SERVICE");

        String uri = instanceList.get(0).getUri().toString();
        WebClient client = WebClient.create(uri + "/credit-report");

        ReportResponse apiResponse = client.post().header("SERVICE-KEY", authKey).bodyValue(new ReportRequest(request))
                .retrieve().bodyToMono(ReportResponse.class).block();
        String message = "";
        if (apiResponse != null) {
            if (apiResponse.isSuccess()) {
                LOGGER.info(message);
            }
            message = apiResponse.getMessage();
        }

        return ResponseEntity.status(200).body(new Response(message, true));

    }
}
