package org.training.boot.config.gatewayserver.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RouterConfiguration {
/**
    @Bean
    public RouteLocator myRoutes(RouteLocatorBuilder builder) {
        /**
        return builder.routes()
                .route(p -> p
                        .path("/get")
                        .filters(f -> f.addRequestHeader("Hello", "World"))
                        .uri("http://localhost:9001/Produits"))
                .build();
         */
        /**
        return builder.routes()
                .route("produits",
                        p -> p.path("/**")
                        .uri("http://localhost:9001/Produits"))
                .build();
         */
/**

    }
 */

}
