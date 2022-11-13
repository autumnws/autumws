package com.autumn.gatewayserver;

import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;

import io.netty.resolver.DefaultAddressResolverGroup;
import reactor.netty.http.client.HttpClient;

@SpringBootApplication
@EnableEurekaClient
public class GatewayserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayserverApplication.class, args);
	}
	
	@Bean
    @Primary
    public WebClient webClient() {
        HttpClient httpClient = HttpClient.create().resolver(DefaultAddressResolverGroup.INSTANCE);
        return WebClient.builder()
                .clientConnector(new ReactorClientHttpConnector(httpClient))
                .build();
    }
	
	@Bean
	public RouteLocator myRoutes(RouteLocatorBuilder builder) {
	    return builder.routes()
	        .route(p -> p
	            .path("/autumnws/allocations/**")
	            .filters(f -> f.rewritePath("autumnws/allocations/(?<segment>.*)","/allocations/${segment}")
	            				.addResponseHeader("X-Response-Time",new Date().toString()))
	            .uri("lb://ALLOCATIONS-SERVICE")).
	        route(p -> p
		            .path("/autumnws/employees/**")
		            .filters(f -> f.rewritePath("/autumnws/employees/(?<segment>.*)","/employees/${segment}")
		            		.addResponseHeader("X-Response-Time",new Date().toString()))
		            .uri("lb://EMPLOYEES-SERVICE")).
	        route(p -> p
		            .path("/autumnws/space/**")
		            .filters(f -> f.rewritePath("/autumnws/space/(?<segment>.*)","/space/${segment}")
		            		.addResponseHeader("X-Response-Time",new Date().toString()))
		            .uri("lb://SPACE-SERVICE")).
	        route(p -> p
		            .path("/autumnws/locations/**")
		            .filters(f -> f.rewritePath("/autumnws/locations/(?<segment>.*)","/locations/${segment}")
		            		.addResponseHeader("X-Response-Time",new Date().toString()))
		            .uri("lb://LOCATIONS-SERVICE")). 
	        route(p -> p
		            .path("/autumnws/org/**")
		            .filters(f -> f.rewritePath("/autumnws/org/(?<segment>.*)","/org/${segment}")
		            		.addResponseHeader("X-Response-Time",new Date().toString()))
		            .uri("lb://ORG-SERVICE")).build();
	}

}
