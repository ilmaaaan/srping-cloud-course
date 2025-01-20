package com.example.storebookservice.kafka;


import com.example.storebookservice.model.Book;
import com.example.storebookservice.service.BookService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class BookListener {

    private final Logger LOGGER = LoggerFactory.getLogger(BookListener.class);
    private final String TOPIC_LISTEN = "check-book-topic";
    private final String GROUP_LISTEN = "book-group";

    private final ObjectMapper objectMapper;
    private final BookService bookService;

    @Autowired
    public BookListener(ObjectMapper objectMapper, BookService bookService) {
        this.objectMapper = objectMapper;
        this.bookService = bookService;
    }

    @KafkaListener(topics = TOPIC_LISTEN, groupId = GROUP_LISTEN)
    public void listenBook(ConsumerRecord<String, String> record) {
        Book book = null;
        try {
            book = objectMapper.readValue(record.value(), Book.class);
            LOGGER.info("Информация о проверенной книге прочитана");
        } catch (JsonProcessingException e) {
            System.out.println("Ошибка в чтении книги из топика");
            throw new RuntimeException(e);
        }
        book.setStatus("checked");
        bookService.save(book);
        System.out.println(book.toString());
    }
}
