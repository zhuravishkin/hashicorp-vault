package com.zhuravishkin.springboothashicorpvault;

import com.zhuravishkin.springboothashicorpvault.model.Credentials;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.vault.authentication.TokenAuthentication;
import org.springframework.vault.client.VaultEndpoint;
import org.springframework.vault.core.VaultTemplate;
import org.springframework.vault.core.VaultVersionedKeyValueTemplate;
import org.springframework.vault.support.Versioned;

import java.net.URI;
import java.net.URISyntaxException;

@Slf4j
@SpringBootApplication
public class SpringBootHashicorpVaultApplication implements CommandLineRunner {
    private final VaultVersionedKeyValueTemplate vaultTemplate;

    public SpringBootHashicorpVaultApplication() throws URISyntaxException {
        this.vaultTemplate = new VaultVersionedKeyValueTemplate(new VaultTemplate(VaultEndpoint.from(new URI("http://localhost:8200")),
                new TokenAuthentication("hvs.2PZF3QpB0mOSTFrtwrAowmO0")), "secret");
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringBootHashicorpVaultApplication.class, args);
    }

    @Override
    public void run(String... args) {
        log.info("Reading vault secret started:");
        Versioned<Credentials> vaultResponse = vaultTemplate.get("/cats", Versioned.Version.from(2), Credentials.class);
        log.info("Version: {}", vaultResponse.getVersion());
        log.info("Username: {}", vaultResponse.getData().getUsername());
        log.info("Password: {}", vaultResponse.getData().getPassword());
    }
}
