package com.cts.cloudpoc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
public class CustomerApplication {

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(CustomerApplication.class, args);
	}
	
	@Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
	         return builder.build();
    }
}
