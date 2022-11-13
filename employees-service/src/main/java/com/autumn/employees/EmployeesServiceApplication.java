package com.autumn.employees;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import brave.http.HttpRequest;
import io.micrometer.core.aop.TimedAspect;
import io.micrometer.core.instrument.MeterRegistry;

@SpringBootApplication
@EnableFeignClients
@RefreshScope
@ComponentScans({ @ComponentScan("com.autumn.employees.controller")})
@EnableJpaRepositories("com.autumn.employees.repository")
@EntityScan("com.autumn.employees.model")
public class EmployeesServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeesServiceApplication.class, args);
	}
	
	@Bean
	public TimedAspect timedAspect(MeterRegistry registry) {
	    return new TimedAspect(registry);
	}

}
