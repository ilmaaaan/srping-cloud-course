package com.example.creationbookservice.model;

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

//    public static class BookBuilder {
//        private Long id;
//        private String name;
//        private String description;
//        private String status;
//        private Long price;
//
//        public BookBuilder(Long id, String name, String description, String status, Long price) {
//            this.id = id;
//            this.name = name;
//            this.description = description;
//            this.status = status;
//            this.price = price;
//        }
//
//        public BookBuilder id(Long id) {
//            this.id = id;
//            return this;
//        }
//
//        public BookBuilder name(String name) {
//            this.name = name;
//            return this;
//        }
//
//        public BookBuilder description(String description) {
//            this.description = description;
//            return this;
//        }
//
//        public BookBuilder status(String status) {
//            this.status = status;
//            return this;
//        }
//
//        public BookBuilder price(Long price) {
//            this.price = price;
//            return this;
//        }
//
//        public Book build() {
//            return new Book(id, name, description, status, price);
//        }
//    }
}
