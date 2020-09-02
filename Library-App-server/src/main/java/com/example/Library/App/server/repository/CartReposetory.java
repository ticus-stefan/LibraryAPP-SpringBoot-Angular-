package com.example.Library.App.server.repository;

import com.example.Library.App.server.model.Book;
import com.example.Library.App.server.model.Cart;
import com.example.Library.App.server.model.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CartReposetory extends CrudRepository<Cart,Long>{
    @Query("SELECT c.bookId  FROM Cart c where c.userId =:userId")
    List<Book> findBookByUser(@Param("userId") User userId);

    @Transactional
    @Modifying
    @Query("Delete  FROM Cart  where bookId =:id")
    void DeleteCartByBook(@Param("id") Book id);

}
