
package com.ReUseTech.com.ReUseTech.mapper;

import com.ReUseTech.com.ReUseTech.dto.CartDTO;
import com.ReUseTech.com.ReUseTech.dto.CartItemDTO;
import com.ReUseTech.com.ReUseTech.model.Cart;
import com.ReUseTech.com.ReUseTech.model.CartItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CartMapper {
    CartMapper INSTANCE = Mappers.getMapper(CartMapper.class);

    CartDTO toCartDTO(Cart cart);

    Cart toCart(CartDTO cartDTO);
}
