package com.example.Library.App.server.controller;

import com.example.Library.App.server.dto.OrderDTO;
import com.example.Library.App.server.dto.UserLoginDTO;
import com.example.Library.App.server.dto.UserRegisterDTO;
import com.example.Library.App.server.model.Book;
import com.example.Library.App.server.model.Cart;
import com.example.Library.App.server.model.Order;
import com.example.Library.App.server.model.User;
import com.example.Library.App.server.service.BookService;
import com.example.Library.App.server.service.CartService;
import com.example.Library.App.server.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@CrossOrigin
@RestController()
@RequestMapping("/library")
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private CartService cartService;

    @Autowired
    private OrderService orderService;

    @GetMapping(path="/all")
    public ResponseEntity<List<Book>> getBooks(){
        return ResponseEntity.ok(bookService.getBooks());
    }

    @GetMapping(path = "all/{id}")
    public ResponseEntity<Optional<Book>> getBook(@PathVariable final Long id) {

        return ResponseEntity.ok(bookService.findBookByID(id));
    }
    @PostMapping(path = "all/{bookId}")
    public ResponseEntity<Cart> addBookToCart(@PathVariable final Long bookId){
        return ResponseEntity.ok(cartService.addBookToCart(bookId));
    }
    @GetMapping(path = "/cart/{userId}")
    public ResponseEntity<List<Book>> findBooks(@PathVariable final Long userId){
        return  ResponseEntity.ok(cartService.findBookByUser(userId));
    }
    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<Cart> deleteCart(@PathVariable  Long id) {
        cartService.deleteCart(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping(path = "/order")
    public ResponseEntity<Order> addOrder(@RequestBody OrderDTO orderDTO) {
        return ResponseEntity.ok(orderService.addOrder(orderDTO));
    }
    @DeleteMapping(path = "/order")
    public ResponseEntity<Cart> deleteAll(){
        cartService.deleteAll();
        return ResponseEntity.noContent().build();
    }
}