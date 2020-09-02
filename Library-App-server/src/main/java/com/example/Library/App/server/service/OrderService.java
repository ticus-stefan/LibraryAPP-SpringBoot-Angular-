package com.example.Library.App.server.service;

import com.example.Library.App.server.dto.OrderDTO;
import com.example.Library.App.server.model.Order;

public interface OrderService {
    Order addOrder(OrderDTO orderDTO);
}
