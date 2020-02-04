package com.wandson.cliente;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import com.wandson.cliente.config.property.ClienteApiProperty;

@SpringBootApplication
@EnableConfigurationProperties(ClienteApiProperty.class)
public class ClienteApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClienteApiApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

}
