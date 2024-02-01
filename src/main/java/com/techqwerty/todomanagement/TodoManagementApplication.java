package com.techqwerty.todomanagement;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

@OpenAPIDefinition(
	info = @Info(
		title = "Todo Management Application Spring Boot Rest API Documentation",
		description = "Spring Boot rest api documentation for todo manaagement rest api application",
		version = "v1.0",
		contact = @Contact(
			name = "Wale Amoo",
			email = "info@techqwerty.com",
			url = "https://www.techqwerty.com"
		),
		license = @License(
			name = "Apache 2.0",
			url = "https://www.techqwerty.com"
		)
	), 
	externalDocs = @ExternalDocumentation(
		description = "Todo Management Application Spring Boot Rest API External Documentation",
		url = "https://www.techqwerty.com"
	)
)

@SpringBootApplication
public class TodoManagementApplication {

	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}
	public static void main(String[] args) {
		SpringApplication.run(TodoManagementApplication.class, args);
	}

}
