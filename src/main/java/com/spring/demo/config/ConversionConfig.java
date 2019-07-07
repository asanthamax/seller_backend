package com.spring.demo.config;

import converter.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ConversionServiceFactoryBean;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;


import java.util.HashSet;
import java.util.Set;

@Configuration
public class ConversionConfig {

    private Set<Converter> getConverters(){

        Set<Converter> converters = new HashSet<Converter>();
        converters.add(new RoomEntityToReservationResponseConverter());
        converters.add(new ReservationRequestToReserveResponseConverter());
        converters.add(new ReservationEntityToReserveResponseConverter());
        converters.add(new ResetPasswordEntityToResetPasswordResponse());
        converters.add(new AdsEntityToAdsResponseConverter());
        converters.add(new AdSaveRequestToAdaddResponseConverter());
        return converters;
    }

    @Bean
    public ConversionService conversionService(){

        ConversionServiceFactoryBean bean = new ConversionServiceFactoryBean();
        bean.setConverters(getConverters());
        bean.afterPropertiesSet();

        return bean.getObject();
    }
}
