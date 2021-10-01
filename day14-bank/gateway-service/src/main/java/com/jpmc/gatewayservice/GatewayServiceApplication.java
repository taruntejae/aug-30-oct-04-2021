package com.jpmc.gatewayservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
public class GatewayServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayServiceApplication.class, args);
    }

    @Bean
    public RouteLocator configureRoutes(RouteLocatorBuilder builder) {
        return builder
                .routes()
                .route("bankdeposit-v1",
                        route -> route
                                    .path("/api/v1/deposit/**")
                                    .filters(f -> f.stripPrefix(3).prefixPath("/account/deposit"))
                                    //.uri("lb://account-service"))
                                    .uri("http://localhost:8081"))
                .route("bankwithdraw-v1",
                        route -> route
                                .path("/api/v1/withdraw/**")
                                .filters(f -> f.stripPrefix(3).prefixPath("/account/withdraw"))
                                .uri("lb://account-service"))
                .build();
    }
}
