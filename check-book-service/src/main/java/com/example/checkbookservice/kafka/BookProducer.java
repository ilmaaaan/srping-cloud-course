package com.example.checkbookservice.kafka;



import com.example.checkbookservice.model.Book;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;


@Service
public class BookProducer {
    private final KafkaTemplate<String, String> kafkaTemplate;
    private static final String BOOK_TOPIC = "check-book-topic";
    private final ObjectMapper objectMapper;

    @Autowired
    public BookProducer(KafkaTemplate<String, String> kafkaTemplate, ObjectMapper objectMapper) {
        this.kafkaTemplate = kafkaTemplate;
        this.objectMapper = objectMapper;
    }

    public void send(Book book)  {
        try {
            String jsonBook = objectMapper.writeValueAsString(book);
            kafkaTemplate.send(BOOK_TOPIC, jsonBook);
        } catch (JsonProcessingException e) {
            System.out.println("Ошибка при парсинге JSON из Book");
            throw new RuntimeException(e);

        }

    }
}