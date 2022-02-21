package com.masterprice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class CrudMasterPriceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudMasterPriceApplication.class, args);
	}

}
