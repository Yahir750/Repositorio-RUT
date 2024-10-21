package com.ReUseTech.com.ReUseTech.mapper;


import com.ReUseTech.com.ReUseTech.dto.OrderDTO;
import com.ReUseTech.com.ReUseTech.model.Order;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


@Mapper
public interface OrderMapper {
    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

    OrderDTO toOrderDTO(Order order);
    Order toOrder(OrderDTO orderDTO);

}