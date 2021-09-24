package com.jpmc.day11calcui.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Configuration
public class AppConfiguration {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public RestTemplate restTemplateWithHeaders() {
        RestTemplate template = new RestTemplate();
        //Configure http headers; security tokens to be passed with every request;
        //timeout configuration
        //default error handlers
        HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
        factory.setReadTimeout(10000); // setting timeout as read timeout
        factory.setConnectTimeout(10000); // setting timeout as connect timeout
        template.setRequestFactory(factory);
        return template;
    }
}
