package com.example.creationbookservice.util;

import com.example.creationbookservice.model.Book;
import org.springframework.stereotype.Component;

@Component
public class BookGenerator {
    private Long id = 0L;

    public Book generateBook() {
        return Book.builder()
                .id(id++)
                .name("Book Name" + id)
                .description("Book Description" + id)
                .status("unchecked")
                .price(id * 100 - id)
                .build();
    }

}
