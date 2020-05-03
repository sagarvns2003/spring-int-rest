package com.vidya;

import java.util.TimeZone;

import javax.annotation.PostConstruct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.IntegrationComponentScan;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@Configuration
@EnableIntegration
@IntegrationComponentScan
@EnableRetry
@EnableAsync
@EnableWebSecurity
public class IntRestApplication {
	public static void main(String[] args) {
		SpringApplication.run(IntRestApplication.class, args);
	}

	@PostConstruct
	private void setTimeZone() {
		TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
	}
}