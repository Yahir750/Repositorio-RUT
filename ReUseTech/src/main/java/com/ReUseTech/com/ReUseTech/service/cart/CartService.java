
package com.ReUseTech.com.ReUseTech.service.cart;


import com.ReUseTech.com.ReUseTech.dto.CartDTO;
import com.ReUseTech.com.ReUseTech.mapper.CartMapper;
import com.ReUseTech.com.ReUseTech.model.Cart;
import com.ReUseTech.com.ReUseTech.model.Product;
import com.ReUseTech.com.ReUseTech.model.User;
import com.ReUseTech.com.ReUseTech.repository.CartRepository;
import com.ReUseTech.com.ReUseTech.repository.ProductRepository;
import com.ReUseTech.com.ReUseTech.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CartService {
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ProductRepository productRepository;

    public List<CartDTO> getUserCart(Long userId) {
        List<Cart> cartItems = cartRepository.findByUserId(userId);
        return cartItems.stream()
                .map(CartMapper.INSTANCE::toCartDTO)
                .collect(Collectors.toList());
    }

    public CartDTO addToCart(CartDTO cartDTO) {
        User user = userRepository.findById(cartDTO.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));
        Product product = productRepository.findById(cartDTO.getProductId())
                .orElseThrow(() -> new RuntimeException("Product not found"));

        Cart cart = CartMapper.INSTANCE.toCart(cartDTO);
        cart.setUser(user);
        cart.setProduct(product);
        cart.setCreatedAt(LocalDateTime.now());

        cart = cartRepository.save(cart);
        return CartMapper.INSTANCE.toCartDTO(cart);
    }
}
