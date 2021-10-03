package com.ing.reportservice.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.ing.reportservice.dto.CustomerDto;
import com.ing.reportservice.exception.CustomerValidationException;
import com.ing.reportservice.external.SocialSecurityService;
import com.ing.reportservice.external.dto.CitizenApiRequest;
import com.ing.reportservice.external.dto.CitizenApiResponse;
import com.ing.reportservice.model.ContactInformation;
import com.ing.reportservice.model.CreditReport;
import com.ing.reportservice.model.CurrencyType;
import com.ing.reportservice.model.Customer;
import com.ing.reportservice.repository.CreditReportRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class CreditReportService implements ReportService {

    @Autowired
    private CreditReportRepository creditReportRepository;

    @Autowired
    private SocialSecurityService socialSecurityService;

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private InformationService contactInformationService;

    @Value("${socialsecurity.authKey}")
    private String authKey;

    @Override
    public CreditReport createCreditReport(CustomerDto customerRequest) throws CustomerValidationException {
        List<ServiceInstance> instanceList = this.discoveryClient.getInstances("CITIZENAPI");

        String uri = instanceList.get(0).getUri().toString();
        WebClient client = WebClient.create(uri + "/citizen/validate");

        CitizenApiResponse response = client.post()
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .body(BodyInserters.fromValue(CitizenApiRequest.of(customerRequest)))
                .retrieve().bodyToMono(CitizenApiResponse.class).block();

        if (response == null || !response.isSuccess()) {
            throw new CustomerValidationException("Müşteri doğrulama işlemi başarısız oldu.");
        }

        Customer customer = customerService.findCustomerBySsn(customerRequest.getSsn());
        if (customer == null) {
            customer = new Customer(customerRequest);
            customerService.save(customer);
        }

        int payroll = socialSecurityService.retrieveCitizenPayroll(customer.getSsn(), authKey);

        ContactInformation contactInformation = new ContactInformation();
        contactInformation.setEmail(customerRequest.getEmail());
        contactInformation.setPhone(customerRequest.getPhone());
        contactInformationService.save(contactInformation);

        CreditReport creditReport = new CreditReport().customer(customer).currencyType(CurrencyType.TRY)
                .amount(payroll * 5).contactInformation(contactInformation);

        return creditReportRepository.save(creditReport);
    }

    @Override
    public CreditReport getCreditReport(UUID id) {
        Optional<CreditReport> report = creditReportRepository.findById(id);
        if (report.isPresent()) {
            return report.get();
        } else {
            return null;
        }
    }

}
