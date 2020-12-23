package com.service;


import com.pojo.Order;

public interface OrderService {

    int insertOrder(Integer roomId,Order order);
}
