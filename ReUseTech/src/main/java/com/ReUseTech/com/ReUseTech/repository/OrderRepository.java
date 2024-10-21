package com.ReUseTech.com.ReUseTech.repository;


import com.ReUseTech.com.ReUseTech.model.Cart;
import com.ReUseTech.com.ReUseTech.model.Comment;
import com.ReUseTech.com.ReUseTech.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByUserId(Long userId);
}