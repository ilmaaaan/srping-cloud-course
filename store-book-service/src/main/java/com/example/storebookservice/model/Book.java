package com.example.storebookservice.model;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class Book implements Serializable {
    private Long id;
    private String name;
    private String description;
    private String status;
    private Long price;

    public Book(Long id, String name, String description, String status, Long price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.status = status;
        this.price = price;
    }
}
