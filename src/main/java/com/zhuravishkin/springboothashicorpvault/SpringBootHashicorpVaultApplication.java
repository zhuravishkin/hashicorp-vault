package com.zhuravishkin.springboothashicorpvault;

import com.zhuravishkin.springboothashicorpvault.model.Credentials;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@Slf4j
@SpringBootApplication
@EnableConfigurationProperties(Credentials.class)
public class SpringBootHashicorpVaultApplication implements CommandLineRunner {
    private final Credentials credentials;

    public SpringBootHashicorpVaultApplication(Credentials credentials) {
        this.credentials = credentials;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringBootHashicorpVaultApplication.class, args);
    }

    @Override
    public void run(String... args) {
        log.info("Reading vault secret started:");
        log.info(credentials.getUsername());
        log.info(credentials.getPassword());
    }
}
