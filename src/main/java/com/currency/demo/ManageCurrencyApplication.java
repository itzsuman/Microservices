package com.currency.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ManageCurrencyApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(ManageCurrencyApplication.class, args);
	}
	
	/*@Override
    public void run(String...args) throws Exception {
    	logger.info("Inserting -> {}", repository.insert(new Currency(10012L, "US", "0.65")));
    }*/

}

