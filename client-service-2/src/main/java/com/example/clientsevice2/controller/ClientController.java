package com.example.clientsevice2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {

    public ClientController( ) {
    }

    @GetMapping("/test")
    public String getTest() {
        return "client-service2 test";
    }
}
