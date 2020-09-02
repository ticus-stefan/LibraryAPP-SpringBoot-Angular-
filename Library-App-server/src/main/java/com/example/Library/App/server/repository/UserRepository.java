package com.example.Library.App.server.repository;

import com.example.Library.App.server.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Long> {
    User findByEmail(final String email);
}
