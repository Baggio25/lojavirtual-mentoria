package com.baggio.lojavirtualbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EntityScan(basePackages = "com.baggio.lojavirtualbackend.model")
@ComponentScan(basePackages = {"com.*"})
@EnableJpaRepositories(basePackages = {"com.baggio.lojavirtualbackend.repository"})
@EnableTransactionManagement
public class LojavirtualBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(LojavirtualBackendApplication.class, args);
	}

}
