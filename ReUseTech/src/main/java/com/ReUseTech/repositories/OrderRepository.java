package com.ReUseTech.repositories;


import com.ReUseTech.model.Cart;
import com.ReUseTech.model.Comment;
import com.ReUseTech.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByUserId(Long userId);
}
