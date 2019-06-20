package com.sam.springtest.repository.service;


import com.sam.springtest.entity.Order;

public interface OrderService<T, ID> {
    public Order getByOrderNo(String orderNo);
}
