package com.eais.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
 * @SpringBootApplication Spring Boot편의를 위해 
 * @Configuration, @EnableAutoConfiguration, @ComponetScan을 디폴트 속성으로 함께 사용하는 것과 같다
 */
@SpringBootApplication
public class EaisRestApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(EaisRestApiApplication.class, args);
	}

}
