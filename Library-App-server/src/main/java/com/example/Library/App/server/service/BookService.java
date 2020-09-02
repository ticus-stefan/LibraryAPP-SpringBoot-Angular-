package com.example.Library.App.server.service;

import com.example.Library.App.server.model.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {

    List<Book> getBooks();
    Optional<Book> findBookByID(Long id);

}
