package com.example.CleanList;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class CleanListApplication {

	public static void main(String[] args) {
		SpringApplication.run(CleanListApplication.class, args);
	}
	@Bean
	public WebClient.Builder webClientBuilder() {
		return WebClient.builder();
	}

	@Bean
	public WebClient defualtwebClient(WebClient.Builder webClientBuilder) {
		return webClientBuilder
				.baseUrl("https://date.nager.at/api/v3/")
				.build();
	}
}
