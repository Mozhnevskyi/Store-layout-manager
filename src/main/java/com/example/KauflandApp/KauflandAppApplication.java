package com.example.KauflandApp;

import com.example.KauflandApp.entities.Product;
import com.example.KauflandApp.repositories.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class KauflandAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(KauflandAppApplication.class, args);
	}
	@Bean
	CommandLineRunner commandLineRunner(ProductRepository productRepository){
		return runner -> {
			Product product1 = new Product("Tekvicove jadierka", true, "4063367507663");
			productRepository.save(product1);

			Product product2 = new Product("Opavia Zlate Susienky Esicka", true, "8593894806428");
			productRepository.save(product2);
		};
	}
}
