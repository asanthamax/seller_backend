package com.spring.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CommonsRequestLoggingFilter;


@Configuration
public class ApiLogHandler {


    @Bean
    public CommonsRequestLoggingFilter logFilter(){

        CommonsRequestLoggingFilter filter = new CommonsRequestLoggingFilter();
        filter.setIncludeQueryString(true);
        filter.setIncludePayload(true);
        filter.setIncludeHeaders(true);
        filter.setIncludeClientInfo(true);
        filter.setMaxPayloadLength(100000);
        filter.setAfterMessagePrefix("REQUEST DATA: ");
        return filter;
    }
}
