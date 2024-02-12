package com.salesianostriana.dam.SubidaDeArchivos;

import com.salesianostriana.dam.SubidaDeArchivos.service.StorageService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SubidaDeArchivosApplication {

	public static void main(String[] args) {
		SpringApplication.run(SubidaDeArchivosApplication.class, args);
	}

	@Bean
	CommandLineRunner init(StorageService storageService) {
		return (args) -> {
			storageService.deleteAll();
			storageService.init();
		};
	}
}
