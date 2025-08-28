package com.lemon.shop.demoshopee.service;

import com.lemon.shop.demoshopee.entity.Order;
import com.lemon.shop.demoshopee.repository.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepo orderRepo;

    public List<Order> getAllOrders() {
        return orderRepo.findAll();
    }
    public Order getOrderById(int id) {
        return orderRepo.findById(id).get();
    }
    public Order saveOrder(Order order) {
        return orderRepo.save(order);
    }
}
