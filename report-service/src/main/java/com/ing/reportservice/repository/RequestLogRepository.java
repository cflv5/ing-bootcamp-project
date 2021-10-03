package com.ing.reportservice.repository;

import com.ing.reportservice.model.RequestLog;

import org.springframework.data.repository.CrudRepository;

public interface RequestLogRepository extends CrudRepository<RequestLog, Long > {
    
}
