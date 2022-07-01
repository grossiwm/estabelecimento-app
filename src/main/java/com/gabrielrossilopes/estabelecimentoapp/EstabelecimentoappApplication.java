package com.gabrielrossilopes.estabelecimentoapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class EstabelecimentoappApplication {

	public static void main(String[] args) {
		SpringApplication.run(EstabelecimentoappApplication.class, args);
	}

}
