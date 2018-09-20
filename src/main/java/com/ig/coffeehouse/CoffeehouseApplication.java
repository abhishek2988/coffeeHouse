package com.ig.coffeehouse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = { "com.ig.coffeehouse.**" })
public class CoffeehouseApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoffeehouseApplication.class, args);
	}
}
