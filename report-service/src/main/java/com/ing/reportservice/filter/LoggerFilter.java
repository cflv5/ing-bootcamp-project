package com.ing.reportservice.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import com.ing.reportservice.model.RequestLog;
import com.ing.reportservice.service.RequestLogService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class LoggerFilter implements Filter {

    @Autowired
    private RequestLogService logService;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;

        String serviceKey = req.getHeader("SERVICE-KEY");

        if (!serviceKey.isBlank()) {
            RequestLog log = new RequestLog();
            log.setServiceKey(serviceKey);
            logService.saveLog(log);
        }
        chain.doFilter(request, response);
    }

}
