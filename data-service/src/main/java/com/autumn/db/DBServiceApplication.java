package com.autumn.db;

import java.nio.charset.StandardCharsets;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.init.ResourceReader;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.google.common.io.Resources;

import io.micrometer.core.aop.TimedAspect;
import io.micrometer.core.instrument.MeterRegistry;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@SpringBootApplication
@EnableTransactionManagement
public class DBServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DBServiceApplication.class, args);
	}
	
	@Bean
	public TimedAspect timedAspect(MeterRegistry registry) {
	    return new TimedAspect(registry);
	}

	@Bean
	public String dbSql() {
		
		String sql = "";
		try { 
			sql = Resources.toString(Resources.getResource("db.sql"), StandardCharsets.UTF_8);
		} catch( Exception e) {
			e.printStackTrace();
		}
		
		return sql;
	}
		
}
