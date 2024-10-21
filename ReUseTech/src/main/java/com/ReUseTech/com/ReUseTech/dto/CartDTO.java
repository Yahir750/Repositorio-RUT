
package com.ReUseTech.com.ReUseTech.dto;

import lombok.Data;
import java.util.List;


@Data
public class CartDTO {
    private Long id;
    private List<CartItemDTO> items;
    private Long userId;

}
