package com.mingyin.service;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Configuration
public class ServiceA implements IServiceA {

    // @LoadBalanced这个注解，是属于spring cloud的哪个项目的？哪个包的？
    // org.springframework.cloud.client.loadbalancer包
    // spring-cloud-commons这个项目
    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    public String sayHello(String name) {
        RestTemplate restTemplate = getRestTemplate();
        // http://192.168.31.107:8080/sayHello/leo
        return restTemplate.getForObject("http://ServiceA/sayHello/" + name, String.class);
    }

}
