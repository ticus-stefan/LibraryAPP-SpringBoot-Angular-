package com.example.Library.App.server.service;

import com.example.Library.App.server.model.Book;
import com.example.Library.App.server.model.Cart;
import com.example.Library.App.server.model.User;

import java.util.List;

public interface CartService {
    Cart addBookToCart(Long BookId);
    List<Book> findBookByUser(Long UserId);
    void deleteCart( Long id);
    void deleteAll();
}
