package com.example.gateway.routes;

import com.example.gateway.filters.HeaderFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
class RouteConfiguration {

    private final HeaderFilter headerFilter;

    @Autowired
    public RouteConfiguration(HeaderFilter headerFilter) {
        this.headerFilter = headerFilter;
    }

    @Bean
    RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("client-service", r -> r.path("/client/**")
                        .filters(f -> f.filter(headerFilter))
                        .uri("lb://client-service/"))
                .build();
    }
}