package com.lemon.shop.demoshopee.service;

import com.lemon.shop.demoshopee.entity.OrderItem;
import com.lemon.shop.demoshopee.repository.OrderItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderItemService {
    @Autowired
    private OrderItemRepo orderItemRepo;

    public List<OrderItem> findAll() {
        return orderItemRepo.findAll();
    }

    public void save(OrderItem orderItem) {
        orderItemRepo.save(orderItem);
    }


}
