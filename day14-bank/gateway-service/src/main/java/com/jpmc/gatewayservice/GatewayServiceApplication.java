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
                .route("bankdeposit",
                        route -> route
                                    .path("/deposit/**")
                                    .filters(f -> f.stripPrefix(1).prefixPath("/bank/deposit"))
                                    .uri("lb://account-service"))
                .route("bankwithdraw",
                        route -> route
                                .path("/withdraw/**")
                                .filters(f -> f.stripPrefix(1).prefixPath("/bank/withdraw"))
                                .uri("lb://account-service"))
                .build();
    }
}
