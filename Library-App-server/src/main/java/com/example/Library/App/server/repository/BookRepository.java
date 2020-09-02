package com.example.Library.App.server.repository;

import com.example.Library.App.server.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book,Long> {
}
