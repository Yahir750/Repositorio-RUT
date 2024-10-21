
package com.ReUseTech.com.ReUseTech.service;


import com.ReUseTech.com.ReUseTech.dto.CartDTO;
import com.ReUseTech.com.ReUseTech.mapper.CartMapper;
import com.ReUseTech.com.ReUseTech.model.Cart;
import com.ReUseTech.com.ReUseTech.repository.CartRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    public CartDTO getCart(Long cartId) {
        Cart cart = cartRepository.findById(cartId)
                .orElseThrow(() -> new RuntimeException("Cart not found"));
        return CartMapper.INSTANCE.toCartDTO(cart);
    }

    public CartDTO createCart(CartDTO cartDTO) {
        Cart cart = CartMapper.INSTANCE.toCart(cartDTO);
        cart = cartRepository.save(cart);
        return CartMapper.INSTANCE.toCartDTO(cart);
    }

    public CartDTO addToCart(Long userId, Long productId, Integer quantity) {
        return null;
    }

    public void clearCart(Long userId) {

    }

    // Otros métodos relacionados con el carrito
}
