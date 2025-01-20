package com.example.clientsevice2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@SpringBootApplication
@EnableEurekaClient
public class ClientService2Application {
    public static void main(String[] args) {
        SpringApplication.run(ClientService2Application.class, args);
    }

}
