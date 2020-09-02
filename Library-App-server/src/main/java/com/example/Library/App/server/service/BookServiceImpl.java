package com.example.Library.App.server.service;

import com.example.Library.App.server.model.Book;
import com.example.Library.App.server.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepository bookRepository;
    @Override
    public List<Book> getBooks() {
        return (List<Book>) bookRepository.findAll();
    }

    @Override
    public Optional<Book> findBookByID(Long id) {
        return  bookRepository.findById(id);
    }
}
