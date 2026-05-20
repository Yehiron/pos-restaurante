package com.theburgery.pos_restaurant;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class PosRestaurantApplication {

	public static void main(String[] args) {
		SpringApplication.run(PosRestaurantApplication.class, args);
	}

}
