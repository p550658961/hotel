package com.controller;


import com.pojo.Order;
import com.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class OrderController {

    @Autowired
    private OrderService orderService;


    @RequestMapping("/addOrder.do")
    @ResponseBody
    public boolean addOrder(Integer roomId,Double orderMoney,Order order){
        System.out.println(order);
        order.setOderMoney(orderMoney);
        int i = orderService.insertOrder(roomId, order);
        return i>=0;
    }
}
