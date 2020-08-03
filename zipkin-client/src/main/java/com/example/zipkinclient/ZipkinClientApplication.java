package com.example.zipkinclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import zipkin2.server.internal.EnableZipkinServer;

@EnableZipkinServer
@SpringBootApplication
public class ZipkinClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZipkinClientApplication.class, args);
	}

}
