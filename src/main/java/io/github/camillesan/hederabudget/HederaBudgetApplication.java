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
        System.err.println("ewqewqe");
        log.info("=== DATASOURCE: " + env.getProperty("spring.datasource.url"));
        log.info("=== POSTGRES_USER: " + env.getProperty("POSTGRES_USER"));
        log.info("=== POSTGRES_HOST: " + env.getProperty("POSTGRES_HOST"));
        log.info("=== POSTGRES_PASSWORD: " + env.getProperty("POSTGRES_PASSWORD"));
        log.info("=== POSTGRES_DB: " + env.getProperty("POSTGRES_DB"));
    }

    public static void main(String[] args) {
        SpringApplication.run(HederaBudgetApplication.class, args);
    }

}
