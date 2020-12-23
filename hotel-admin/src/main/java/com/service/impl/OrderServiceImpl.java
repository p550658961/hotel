package com.service.impl;

import com.mapper.OrderMapper;
import com.pojo.Order;
import com.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;


@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public int insertOrder(Integer roomId, Order order) {
        Integer integer = orderMapper.selectByInRoomInfo(roomId);
        order.setIriId(integer);
        order.setOrderNum(UUID.randomUUID().toString());
        order.setCreateDate(new Date());
        return orderMapper.insertOrder(order);
    }
}
