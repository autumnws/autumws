package com.autumn.allocations.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.resilience4j.ratelimiter.annotation.RateLimiter;

@RestController
public class MainController {

	@GetMapping("/")
	public String index() {
		return "Hello, Welcome to Autumn Workspace Kubernetes cluster";
	}
}
