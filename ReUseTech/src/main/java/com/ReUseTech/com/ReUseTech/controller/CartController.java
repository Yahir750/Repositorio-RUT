package com.ReUseTech.com.ReUseTech.controller;

import com.ReUseTech.com.ReUseTech.dto.CartDTO;
import com.ReUseTech.com.ReUseTech.service.cart.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cart")
@CrossOrigin(origins = "*")
public class CartController {
    @Autowired
    private CartService cartService;

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<CartDTO>> getUserCart(@PathVariable Long userId) {
        return ResponseEntity.ok(cartService.getUserCart(userId));
    }

    @PostMapping
    public ResponseEntity<CartDTO> addToCart(@RequestBody CartDTO cartDTO) {
        return ResponseEntity.ok(cartService.addToCart(cartDTO));
    }

}
