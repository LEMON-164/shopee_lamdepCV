package com.lemon.shop.demoshopee.repository;

import com.lemon.shop.demoshopee.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;


public interface OrderRepo extends JpaRepository<Order, Integer> {
}
