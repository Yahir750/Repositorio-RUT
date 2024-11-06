
package com.ReUseTech.com.ReUseTech.service.order;


import com.ReUseTech.com.ReUseTech.dto.OrderDTO;
import com.ReUseTech.com.ReUseTech.mapper.OrderMapper;
import com.ReUseTech.com.ReUseTech.model.*;
import com.ReUseTech.com.ReUseTech.repository.OrderRepository;
import com.ReUseTech.com.ReUseTech.repository.ProductRepository;
import com.ReUseTech.com.ReUseTech.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ProductRepository productRepository;

    public List<OrderDTO> getUserOrders(Long userId) {
        List<Order> orders = orderRepository.findByUserId(userId);
        return orders.stream()
                .map(OrderMapper.INSTANCE::toOrderDTO)
                .collect(Collectors.toList());
    }

    public OrderDTO createOrder(OrderDTO orderDTO) {
        User user = userRepository.findById(orderDTO.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Order order = OrderMapper.INSTANCE.toOrder(orderDTO);
        order.setUser(user);
        order.setOrderDate(LocalDateTime.now());
        order.setStatus("PENDING");

        double totalAmount = 0;
        for (OrderItem item : order.getOrderItems()) {
            Product product = productRepository.findById(item.getProduct().getId())
                    .orElseThrow(() -> new RuntimeException("Product not found"));
            item.setOrder(order);
            totalAmount += item.getPrice() * item.getQuantity();
        }
        order.setTotalAmount(totalAmount);

        order = orderRepository.save(order);
        return OrderMapper.INSTANCE.toOrderDTO(order);
    }
}
