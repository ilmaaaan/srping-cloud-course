package com.example.storebookservice.controller;


import com.example.storebookservice.kafka.BookListener;
import com.example.storebookservice.model.Book;
import com.example.storebookservice.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class BookController {

    private final List<Book> allBooks = new ArrayList<>();
    private final Logger LOGGER = LoggerFactory.getLogger(BookController.class);

    private final BookService bookService ;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/checked-books")
    public List<Book> sendBookToKafka() {
        return bookService.getAllBooks();
    }
}
