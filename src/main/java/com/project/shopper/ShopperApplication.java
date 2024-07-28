package com.project.shopper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class ShopperApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShopperApplication.class, args);
	}
}