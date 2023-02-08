package com.example.springbootcachedemo.demo;

public interface BookRepository {
    Book getByIsbn(String isbn);
}
