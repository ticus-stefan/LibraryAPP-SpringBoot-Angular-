package com.example.Library.App.server.service;

import com.example.Library.App.server.dto.OrderDTO;
import com.example.Library.App.server.model.Order;
import com.example.Library.App.server.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Override
    public Order addOrder(OrderDTO orderDTO) {
        if (Objects.isNull(orderDTO)) {
            return null;
        }
        Order order=new Order();
        order.setName(orderDTO.getName());
        order.setAdress(orderDTO.getAdress());
        order.setPrice(orderDTO.getPrice());
        orderRepository.save(order);
        return order;

    }
}
