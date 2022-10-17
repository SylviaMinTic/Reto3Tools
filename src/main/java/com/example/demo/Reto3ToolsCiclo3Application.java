package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;

//@SpringBootApplication(scanBasePackages = {"Controller", "modelo", "repositorio", "servicio"})
@EntityScan(basePackages = {"com.example.demo.modelo"})
//@EnableJdbcRepositories("repositorio")
@SpringBootApplication
public class Reto3ToolsCiclo3Application {

	public static void main(String[] args) {
		SpringApplication.run(Reto3ToolsCiclo3Application.class, args);
	}

}
