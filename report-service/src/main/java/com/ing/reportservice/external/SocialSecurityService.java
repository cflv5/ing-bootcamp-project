package com.ing.reportservice.external;

import java.util.concurrent.ThreadLocalRandom;

import org.springframework.stereotype.Service;

@Service
public class SocialSecurityService {
    public int retrieveCitizenPayroll(String ssn, String authKey) {
        return ThreadLocalRandom.current().nextInt(3000, 15001);
    }
}
