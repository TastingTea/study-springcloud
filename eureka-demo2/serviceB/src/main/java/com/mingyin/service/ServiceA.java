package com.mingyin.service;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Configuration
public class ServiceA implements IServiceA {

    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    public String sayHello(String name) {
        RestTemplate restTemplate = getRestTemplate();
        return restTemplate.getForObject("http://ServiceA/sayHello/" + name, String.class);
    }

}
