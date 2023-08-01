package com.epam.beautysalonspring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;


@Configuration
public class RestTemplateConfig {

    @Bean
    @DependsOn(value = "requestFactory")
    public RestTemplate restTemplate(HttpComponentsClientHttpRequestFactory requestFactory) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setRequestFactory(requestFactory);
        return restTemplate;
    }

    // Fix: Patch Request doesn't supported in plain rest template
    @Bean(name = "requestFactory")
    public HttpComponentsClientHttpRequestFactory requestFactory() {
        return new HttpComponentsClientHttpRequestFactory();
    }
}
