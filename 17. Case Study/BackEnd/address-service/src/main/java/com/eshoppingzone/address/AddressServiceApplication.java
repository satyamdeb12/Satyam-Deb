package com.eshoppingzone.address;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@SpringBootApplication
@EnableEurekaClient
@EnableSwagger2
public class AddressServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AddressServiceApplication.class, args);
	}
	@Bean
	public Docket swagConfig(){
		return new Docket( DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.any())
				.apis(RequestHandlerSelectors.basePackage("com.eshoppingzone.address.controller"))
				.build()
				.pathMapping("/")
				.apiInfo(apiDetails());
	}

	private ApiInfo apiDetails(){
		return new ApiInfo( "Address Service API",
				"The API responsible for storing and updating addresses of users.",
				"1.0",
				"Free to use",
				new springfox.documentation.service.Contact("Satyam Deb", "http://eshoppingzone.com", "email@gmail.com"),
				"API License",
				"http://eshoppingzone.com",
				Collections.emptyList()
		);
	}

}
