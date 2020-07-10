package com.test.movieratings;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MovieRatingsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieRatingsApplication.class, args);
	}

}
