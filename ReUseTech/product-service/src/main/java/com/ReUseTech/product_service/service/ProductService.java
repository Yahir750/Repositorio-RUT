package com.ReUseTech.product_service.service;

import com.ReUseTech.product_service.model.entity.Product;
import com.ReUseTech.product_service.model.dto.ProductDTO;
import com.ReUseTech.product_service.repository.ProductRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ProductDTO createProduct(ProductDTO productDTO) {
        Product product = new Product();
        BeanUtils.copyProperties(productDTO, product);
        Product savedProduct = productRepository.save(product);
        ProductDTO responseDTO = new ProductDTO();
        BeanUtils.copyProperties(savedProduct, responseDTO);
        return responseDTO;
    }

    public ProductDTO getProduct(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        ProductDTO productDTO = new ProductDTO();
        BeanUtils.copyProperties(product, productDTO);
        return productDTO;
    }

    public List<ProductDTO> getAllProducts() {
        return productRepository.findAll().stream()
                .map(product -> {
                    ProductDTO dto = new ProductDTO();
                    BeanUtils.copyProperties(product, dto);
                    return dto;
                })
                .collect(Collectors.toList());
    }

    public ProductDTO updateProduct(Long id, ProductDTO productDTO) {
        Product existingProduct = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        BeanUtils.copyProperties(productDTO, existingProduct, "id");
        Product updatedProduct = productRepository.save(existingProduct);

        ProductDTO responseDTO = new ProductDTO();
        BeanUtils.copyProperties(updatedProduct, responseDTO);
        return responseDTO;
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    public List<ProductDTO> getProductsBySeller(Long sellerId) {
        return productRepository.findBySellerId(sellerId).stream()
                .map(product -> {
                    ProductDTO dto = new ProductDTO();
                    BeanUtils.copyProperties(product, dto);
                    return dto;
                })
                .collect(Collectors.toList());
    }
}