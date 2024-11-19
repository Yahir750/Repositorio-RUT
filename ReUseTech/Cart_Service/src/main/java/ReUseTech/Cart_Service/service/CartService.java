package ReUseTech.Cart_Service.service;

import ReUseTech.Cart_Service.CartDTO.CartDTO;
import ReUseTech.Cart_Service.CartDTO.CartItemDTO;
import ReUseTech.Cart_Service.entity.Cart;
import ReUseTech.Cart_Service.entity.CartItem;
import ReUseTech.Cart_Service.repository.CartRepository;
import ReUseTech.Product_Service.dto.ProductDTO;
import ReUseTech.User_Service.dto.UserDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class CartService {
    private final CartRepository cartRepository;
    private final RestTemplate restTemplate;

    private final String PRODUCT_SERVICE_URL = "http://localhost:8081/products/";
    private final String USER_SERVICE_URL = "http://localhost:8082/users/";

    public CartService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
        this.restTemplate = new RestTemplate();
    }

    public Cart createCart(Cart cart) {
        validateUser(cart.getUserId());
        validateProducts(cart.getItems());
        return cartRepository.save(cart);
    }

    public List<Cart> getAllCarts() {
        return cartRepository.findAll();
    }

    public Optional<CartDTO> getCartById(Long id) {
        Optional<Cart> cart = cartRepository.findById(id);
        return cart.map(this::convertToDTO);
    }

    public Cart updateCart(Long id, Cart updatedCart) {
        if (cartRepository.existsById(id)) {
            validateUser(updatedCart.getUserId());
            validateProducts(updatedCart.getItems());
            updatedCart.setId(id);
            return cartRepository.save(updatedCart);
        }
        return null;
    }

    public boolean deleteCart(Long id) {
        if (cartRepository.existsById(id)) {
            cartRepository.deleteById(id);
            return true;
        }
        return false;
    }

    private void validateUser(Long userId) {
        try {
            ResponseEntity<UserDTO> response = restTemplate.getForEntity(
                    USER_SERVICE_URL + userId,
                    UserDTO.class
            );
            if (!response.getStatusCode().is2xxSuccessful()) {
                throw new RuntimeException("User not found with id: " + userId);
            }
        } catch (RestClientException e) {
            throw new RuntimeException("Error validating user with id: " + userId);
        }
    }

    private void validateProducts(List<CartItem> items) {
        for (CartItem item : items) {
            try {
                ResponseEntity<ProductDTO> response = restTemplate.getForEntity(
                        PRODUCT_SERVICE_URL + item.getProductId(),
                        ProductDTO.class
                );
                if (!response.getStatusCode().is2xxSuccessful()) {
                    throw new RuntimeException("Product not found with id: " + item.getProductId());
                }
            } catch (RestClientException e) {
                throw new RuntimeException("Error validating product with id: " + item.getProductId());
            }
        }
    }

    private CartDTO convertToDTO(Cart cart) {
        CartDTO dto = new CartDTO();
        dto.setId(cart.getId());
        dto.setUserId(cart.getUserId());

        List<CartItemDTO> itemDTOs = new ArrayList<>();
        double total = 0;

        for (CartItem item : cart.getItems()) {
            try {
                ResponseEntity<ProductDTO> response = restTemplate.getForEntity(
                        PRODUCT_SERVICE_URL + item.getProductId(),
                        ProductDTO.class
                );

                if (response.getStatusCode().is2xxSuccessful() && response.getBody() != null) {
                    ProductDTO product = response.getBody();
                    CartItemDTO itemDTO = new CartItemDTO();
                    itemDTO.setId(item.getId());
                    itemDTO.setProductId(item.getProductId());
                    itemDTO.setProductName(product.getName());
                    itemDTO.setProductDescription(product.getDescription());
                    itemDTO.setProductPrice(product.getPrice());
                    itemDTO.setQuantity(item.getQuantity());
                    itemDTO.setSubtotal(product.getPrice() * item.getQuantity());

                    total += itemDTO.getSubtotal();
                    itemDTOs.add(itemDTO);
                }
            } catch (RestClientException e) {
                log.error("Error fetching product details for id: " + item.getProductId(), e);
            }
        }

        dto.setItems(itemDTOs);
        dto.setTotal(total);
        return dto;
    }
}