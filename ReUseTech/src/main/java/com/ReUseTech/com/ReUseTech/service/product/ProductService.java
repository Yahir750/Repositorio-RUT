
package com.ReUseTech.com.ReUseTech.service.product;


import com.ReUseTech.com.ReUseTech.dto.ProductDTO;
import com.ReUseTech.com.ReUseTech.mapper.ProductMapper;
import com.ReUseTech.com.ReUseTech.model.Product;
import com.ReUseTech.com.ReUseTech.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public ProductDTO getProduct(Long productId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        return ProductMapper.INSTANCE.toProductDTO(product);
    }

    public List<ProductDTO> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products.stream()
                .map(ProductMapper.INSTANCE::toProductDTO)
                .collect(Collectors.toList());
    }

    public ProductDTO createProduct(ProductDTO productDTO) {
        Product product = ProductMapper.INSTANCE.toProduct(productDTO);
        product = productRepository.save(product);
        return ProductMapper.INSTANCE.toProductDTO(product);
    }
}
