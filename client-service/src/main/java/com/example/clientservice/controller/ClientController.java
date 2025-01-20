package com.example.clientservice.controller;

import com.example.clientservice.model.Book;
import com.example.clientservice.connector.BookServiceFeignClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping("/client")
public class ClientController {

    private static final Logger LOG = Logger.getLogger(ClientController.class.getName());
    private final BookServiceFeignClient bookServiceFeignClient;

    @Autowired
    public ClientController(BookServiceFeignClient bookServiceFeignClient) {
        this.bookServiceFeignClient = bookServiceFeignClient;
    }

    @GetMapping("/books")
    public List<Book> getAllBookFromBookService() {
        LOG.log(Level.INFO, "getAllBookFromBookService");
        List<Book> books =  bookServiceFeignClient.getAllBooks();
        return books;
    }

    @GetMapping("/test")
    public String getTest() {
        return "client-service1 test";
    }
}
