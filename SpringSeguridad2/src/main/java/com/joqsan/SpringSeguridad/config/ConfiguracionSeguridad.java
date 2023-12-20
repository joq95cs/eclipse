package com.joqsan.SpringSeguridad.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

@Configuration
@EnableWebSecurity
public class ConfiguracionSeguridad extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		UserBuilder usuarios = User.withDefaultPasswordEncoder();
		auth.inMemoryAuthentication()
		.withUser(usuarios.username("Kimera").password("kimera").roles("administrador"))
		.withUser(usuarios.username("Sanson").password("sanson").roles("usuario"))
		.withUser(usuarios.username("Zela").password("zela").roles("ayudante"))
		.withUser(usuarios.username("Simbel").password("simbel").roles("administrador"));
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.authorizeRequests().anyRequest().authenticated().and().formLogin()
		.loginPage("/formLogin")
		.loginProcessingUrl("/login")
		.permitAll();
	}
}