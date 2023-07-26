package com.cda.api;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;


@SpringBootApplication
@ConfigurationProperties("images.path")
public class CdaApi {
    public static void main(String[] args) {
        SpringApplication.run(CdaApi.class, args);
    }
}
