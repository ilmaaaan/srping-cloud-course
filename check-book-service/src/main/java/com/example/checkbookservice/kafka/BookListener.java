package com.example.checkbookservice.kafka;

import com.example.checkbookservice.model.Book;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class BookListener {

    private final Logger LOGGER = LoggerFactory.getLogger(BookListener.class);
    private final String TOPIC_LISTEN = "book-topic";
    private final String GROUP_LISTEN = "book-group";

    private final ObjectMapper objectMapper;
    private final BookProducer bookProducer;


    @Autowired
    public BookListener(ObjectMapper objectMapper, BookProducer bookProducer) {
        this.objectMapper = objectMapper;
        this.bookProducer = bookProducer;
    }

    @KafkaListener(topics = TOPIC_LISTEN, groupId = GROUP_LISTEN)
    public void listenBook(String bookMessage) {
        Book book = null;
        try {
            book = objectMapper.readValue(bookMessage, Book.class);
            LOGGER.info("Информация о непроверенной книге прочитана");
        } catch (JsonProcessingException e) {
            System.out.println("Ошибка в чтении книги из топика");
            throw new RuntimeException(e);
        }
        book.setStatus("checked");
        bookProducer.send(book);
        System.out.println(book.toString());
    }
}
