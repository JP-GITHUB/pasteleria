package com.jp.pasteleria.pasteleria;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaAuditing
@ComponentScan("com.jp.pasteleria.controller")
@EntityScan("com.jp.pasteleria.model")
@EnableJpaRepositories("com.jp.pasteleria.repository")
public class PasteleriaApplication {
	public static final Logger logger = LoggerFactory.getLogger(PasteleriaApplication.class);	

	public static void main(String[] args) {
		SpringApplication.run(PasteleriaApplication.class, args);
		logger.info("--Application Started--");
	}
}
