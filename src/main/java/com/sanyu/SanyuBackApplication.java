package com.sanyu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

//Se evita que se haga necesario estar autenticado para consultar la aplicación
@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class SanyuBackApplication {
	public static void main(String[] args) {
		SpringApplication.run(SanyuBackApplication.class, args);
	}
}
