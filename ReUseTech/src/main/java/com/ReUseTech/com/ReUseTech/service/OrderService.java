
package com.ReUseTech.com.ReUseTech.service;


import com.ReUseTech.com.ReUseTech.dto.OrderDTO;
import com.ReUseTech.com.ReUseTech.mapper.OrderMapper;
import com.ReUseTech.com.ReUseTech.model.*;
import com.ReUseTech.com.ReUseTech.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public OrderDTO getOrder(Long orderId) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found"));
        return OrderMapper.INSTANCE.toOrderDTO(order);
    }

    public List<OrderDTO> getOrdersByUser(Long userId) {
        List<Order> orders = orderRepository.findByUserId(userId);
        return orders.stream()
                .map(OrderMapper.INSTANCE::toOrderDTO)
                .collect(Collectors.toList());
    }

    public OrderDTO createOrder(OrderDTO orderDTO) {
        Order order = OrderMapper.INSTANCE.toOrder(orderDTO);
        order = orderRepository.save(order);
        return OrderMapper.INSTANCE.toOrderDTO(order);
    }
}
