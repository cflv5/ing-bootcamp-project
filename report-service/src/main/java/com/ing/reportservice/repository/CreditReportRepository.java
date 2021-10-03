package com.ing.reportservice.repository;

import java.util.UUID;

import com.ing.reportservice.model.CreditReport;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditReportRepository extends CrudRepository<CreditReport, UUID> {

}
