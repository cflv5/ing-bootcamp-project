package com.ing.reportservice.service;

import com.ing.reportservice.model.RequestLog;
import com.ing.reportservice.repository.RequestLogRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RequestLogService {
    @Autowired
    private RequestLogRepository requestLogRepository;

    public void saveLog(RequestLog log) {
        requestLogRepository.save(log);
    }
}
