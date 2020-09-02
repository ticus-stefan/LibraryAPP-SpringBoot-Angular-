package com.example.Library.App.server.repository;

import com.example.Library.App.server.model.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order,Long> {
}
