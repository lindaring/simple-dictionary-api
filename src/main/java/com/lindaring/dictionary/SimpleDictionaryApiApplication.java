package com.lindaring.dictionary;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class SimpleDictionaryApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimpleDictionaryApiApplication.class, args);
	}

}
