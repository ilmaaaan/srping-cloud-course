package com.example.bookservice.service;

import com.example.bookservice.model.Book;
import org.springframework.stereotype.Service;

import java.util.List;

public interface BookService {
    List<Book> findAll();
}
