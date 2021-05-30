package com.uno.store;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.uno.store.repository.ProductRepository;

@SpringBootApplication
public class StoreBackApplication {
	
	@Autowired
	ProductRepository productRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(StoreBackApplication.class, args);
	}
	@Bean
	InitializingBean sendDatabase() {
	    return () -> {
	    	productRepository.initializeListProduct();
	      };
	   }
	
}
