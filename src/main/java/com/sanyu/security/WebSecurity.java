package com.sanyu.security;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;

//Clase para permitir peticiones a la API y para permitir que Swagger cree su documentación
public class WebSecurity {
	protected void configure(HttpSecurity http) throws Exception {
		http.cors().and().csrf().disable().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
				.and().authorizeRequests().antMatchers("/api/auth/**").permitAll()
				 //Permitir que todas las rutas sean visibles para Swagger
				.antMatchers("/**").permitAll()
				.anyRequest().authenticated();
	}
}
