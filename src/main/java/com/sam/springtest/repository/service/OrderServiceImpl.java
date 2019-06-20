package com.sam.springtest.repository.service;

import com.sam.springtest.entity.Order;
import com.sam.springtest.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Override
    public Order getByOrderNo(String orderNo) {
        return orderRepository.findByOrderNo(orderNo);
    }
}
