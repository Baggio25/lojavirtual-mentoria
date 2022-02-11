package com.baggio.lojavirtualbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class LojavirtualBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(LojavirtualBackendApplication.class, args);
	}

}
