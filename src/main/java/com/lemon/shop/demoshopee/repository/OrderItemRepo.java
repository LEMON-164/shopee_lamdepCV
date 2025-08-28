package com.lemon.shop.demoshopee.repository;

import com.lemon.shop.demoshopee.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;


public interface OrderItemRepo extends JpaRepository<OrderItem, Integer> {
}
