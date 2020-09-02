package com.example.Library.App.server.service;

import com.example.Library.App.server.model.Book;
import com.example.Library.App.server.model.Cart;
import com.example.Library.App.server.model.User;
import com.example.Library.App.server.repository.BookRepository;
import com.example.Library.App.server.repository.CartReposetory;
import com.example.Library.App.server.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class CartServiceImpl implements CartService {
@Autowired
    private CartReposetory cartReposetory;
@Autowired
private BookRepository bookRepository;
@Autowired
private UserRepository userRepository;

    @Override
    public Cart addBookToCart(Long bookId) {
        Cart cart=new Cart();
        Book book=bookRepository.findById(bookId).get();
        User user=userRepository.findById(new Long(1)).get();
        cart.setBookId(book);
        cart.setUserId(user);
        cartReposetory.save(cart);
        return cart;
    }

    @Override
    public List<Book> findBookByUser(Long Id) {
        User user=userRepository.findById(Id).get();
        return cartReposetory.findBookByUser(user);
    }

    @Override
    public void deleteCart(Long id) {
        Book book=bookRepository.findById(id).get();
        cartReposetory.DeleteCartByBook(book);
    }

    @Override
    public void deleteAll() {
        cartReposetory.deleteAll();
    }
}
