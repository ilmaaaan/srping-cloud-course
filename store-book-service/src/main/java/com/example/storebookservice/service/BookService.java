package com.example.storebookservice.service;

import com.example.storebookservice.model.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    private final List<Book> checkedBooks = new ArrayList<>();

    public void save(Book book) {
        checkedBooks.add(book);
    }

    public List<Book> getAllBooks() {
        return checkedBooks;
    }
}
