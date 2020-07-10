package com.test.microservicefilm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker
public class MicroserviceFilmApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroserviceFilmApplication.class, args);
    }

}
