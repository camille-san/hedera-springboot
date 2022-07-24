package io.github.camillesan.hedera;

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
        log.info("Datasource url used: {}", env.getProperty("spring.datasource.url"));
        log.info("Datasource user used: {}", env.getProperty("spring.datasource.username"));
    }

    public static void main(String[] args) {
        SpringApplication.run(HederaBudgetApplication.class, args);
    }

}
