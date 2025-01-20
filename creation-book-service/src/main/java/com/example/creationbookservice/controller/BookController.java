package com.example.creationbookservice.controller;

import com.example.creationbookservice.kafka.BookProducerService;
import com.example.creationbookservice.model.Book;
import com.example.creationbookservice.util.BookGenerator;
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
    private final BookProducerService bookProducerService;
    private final BookGenerator bookGenerator;

    @Autowired
    public BookController(BookProducerService bookProducerService, BookGenerator bookGenerator) {
        this.bookProducerService = bookProducerService;
        this.bookGenerator = bookGenerator;
    }

    @GetMapping("/unchecked-books")
    public List<Book> sendBookToKafka() {
        Book newBook = bookGenerator.generateBook();
        bookProducerService.send(newBook);
        LOGGER.info("Message about new book was sent to kafka into topic: book-topic");
        allBooks.add(newBook);
        return allBooks;
    }
}
