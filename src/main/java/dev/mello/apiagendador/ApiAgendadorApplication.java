package dev.mello.apiagendador;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ApiAgendadorApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiAgendadorApplication.class, args);
	}

}
