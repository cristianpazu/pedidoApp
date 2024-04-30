package com.example.PedidoApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@ComponentScan(basePackages = {"com.example.*"})
@EntityScan(basePackages = {"com.example.*"})
@EnableJpaRepositories(basePackages = {"com.example.*"})
public class PedidoAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(PedidoAppApplication.class, args);
	}

}
