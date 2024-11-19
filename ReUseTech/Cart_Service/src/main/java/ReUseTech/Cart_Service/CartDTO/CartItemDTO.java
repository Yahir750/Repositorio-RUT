package ReUseTech.Cart_Service.CartDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartItemDTO {
    private Long id;
    private Long productId;
    private String productName;
    private String productDescription;
    private double productPrice;
    private Integer quantity;
    private double subtotal;
}