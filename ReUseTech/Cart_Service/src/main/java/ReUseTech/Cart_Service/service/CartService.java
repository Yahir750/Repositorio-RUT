package ReUseTech.Cart_Service.service;

import ReUseTech.Cart_Service.entity.Cart;
import ReUseTech.Cart_Service.entity.CartItem;
import ReUseTech.Cart_Service.repository.CartRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CartService {

    private final CartRepository cartRepository;

    public CartService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    // Crear un nuevo carrito
    public Cart createCart(Cart cart) {
        return cartRepository.save(cart);
    }

    // Obtener todos los carritos
    public List<Cart> getAllCarts() {
        return cartRepository.findAll();
    }

    // Obtener un carrito por su ID
    public Optional<Cart> getCartById(Long id) {
        return cartRepository.findById(id);
    }

    // Actualizar un carrito
    public Cart updateCart(Long id, Cart updatedCart) {
        if (cartRepository.existsById(id)) {
            updatedCart.setId(id);
            return cartRepository.save(updatedCart);
        }
        return null; // O lanzar una excepción personalizada
    }

    // Eliminar un carrito
    public boolean deleteCart(Long id) {
        if (cartRepository.existsById(id)) {
            cartRepository.deleteById(id);
            return true;
        }
        return false; // O lanzar una excepción personalizada
    }
}