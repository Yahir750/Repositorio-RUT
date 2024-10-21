
package com.ReUseTech.com.ReUseTech.mapper;

import com.ReUseTech.com.ReUseTech.dto.ProductDTO;
import com.ReUseTech.com.ReUseTech.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


@Mapper
public interface ProductMapper {
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    ProductDTO toProductDTO(Product product);
    Product toProduct(ProductDTO productDTO);
}
