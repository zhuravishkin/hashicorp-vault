package com.zhuravishkin.springboothashicorpvault.model;

import lombok.*;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties("reeves")
public class Credentials {
    private String username;
    private String password;
}
