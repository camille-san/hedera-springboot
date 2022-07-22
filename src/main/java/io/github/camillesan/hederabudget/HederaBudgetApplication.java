package io.github.camillesan.hederabudget;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

@SpringBootApplication
@Slf4j
public class HederaBudgetApplication implements CommandLineRunner {
	@Autowired
	private Environment env;

	@Override
	public void run(String... args) {
		log.info("============== {}", env.getProperty("spring.datasource.url"));
		log.info("============== {}", env.getProperty("spring.datasource.username"));
		log.info("============== {}", env.getProperty("spring.datasource.password"));
	}
	public static void main(String[] args) {
		System.err.println("=============== hello");
		SpringApplication.run(HederaBudgetApplication.class, args);
	}

}
