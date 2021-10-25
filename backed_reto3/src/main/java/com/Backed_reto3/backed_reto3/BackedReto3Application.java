package com.Backed_reto3.backed_reto3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;


@EntityScan(basePackages = {"com.Backed_reto3.backed_reto3.Entidad"})
@SpringBootApplication
public class BackedReto3Application {

	public static void main(String[] args) {
		SpringApplication.run(BackedReto3Application.class, args);
	}

}
