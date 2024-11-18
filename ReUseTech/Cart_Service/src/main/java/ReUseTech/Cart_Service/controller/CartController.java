package ReUseTech.Cart_Service.controller;

import ReUseTech.Cart_Service.entity.Cart;
import ReUseTech.Cart_Service.entity.CartItem;
import ReUseTech.Cart_Service.service.CartService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/carts")
public class CartController {

    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    // Crear un nuevo carrito
    @PostMapping
    public ResponseEntity<Cart> createCart(@RequestBody Cart cart) {
        return new ResponseEntity<>(cartService.createCart(cart), HttpStatus.CREATED);
    }

    // Obtener todos los carritos
    @GetMapping
    public List<Cart> getAllCarts() {
        return cartService.getAllCarts();
    }

    // Obtener un carrito por su ID
    @GetMapping("/{id}")
    public ResponseEntity<Cart> getCartById(@PathVariable Long id) {
        Optional<Cart> cart = cartService.getCartById(id);
        return cart.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Actualizar un carrito
    @PutMapping("/{id}")
    public ResponseEntity<Cart> updateCart(@PathVariable Long id, @RequestBody Cart updatedCart) {
        Cart cart = cartService.updateCart(id, updatedCart);
        return cart != null ? new ResponseEntity<>(cart, HttpStatus.OK) : ResponseEntity.notFound().build();
    }

    // Eliminar un carrito
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCart(@PathVariable Long id) {
        return cartService.deleteCart(id) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
