package com.sami.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "com.sami.springboot")
@Data
public class CustomProperties {
    private String apiUrl;
}
