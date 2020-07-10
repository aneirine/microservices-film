package com.test.microservicefilm;

import com.google.inject.internal.cglib.proxy.$NoOp;
import com.netflix.discovery.DiscoveryClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
@EnableEurekaClient
public class MicroserviceFilmApplication {


    public static void main(String[] args) {
        SpringApplication.run(MicroserviceFilmApplication.class, args);
    }

}
