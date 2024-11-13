package com.ReUseTech.product_service.controller;

import com.ReUseTech.product_service.service.ProductService;
import com.ReUseTech.product_service.model.dto.ProductDTO;
import com.ReUseTech.product_service.model.dto.ProductResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@CrossOrigin(origins = "*")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<ProductResponse> createProduct(@RequestBody ProductDTO productDTO) {
        ProductDTO createdProduct = productService.createProduct(productDTO);
        return ResponseEntity.ok(ProductResponse.builder()
                .success(true)
                .message("Product created successfully")
                .data(createdProduct)
                .build());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> getProduct(@PathVariable Long id) {
        ProductDTO product = productService.getProduct(id);
        return ResponseEntity.ok(ProductResponse.builder()
                .success(true)
                .data(product)
                .build());
    }

    @GetMapping
    public ResponseEntity<ProductResponse> getAllProducts() {
        List<ProductDTO> products = productService.getAllProducts();
        return ResponseEntity.ok(ProductResponse.builder()
                .success(true)
                .data(products)
                .build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductResponse> updateProduct(
            @PathVariable Long id,
            @RequestBody ProductDTO productDTO) {
        ProductDTO updatedProduct = productService.updateProduct(id, productDTO);
        return ResponseEntity.ok(ProductResponse.builder()
                .success(true)
                .message("Product updated successfully")
                .data(updatedProduct)
                .build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ProductResponse> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.ok(ProductResponse.builder()
                .success(true)
                .message("Product deleted successfully")
                .build());
    }

    @GetMapping("/seller/{sellerId}")
    public ResponseEntity<ProductResponse> getProductsBySeller(@PathVariable Long sellerId) {
        List<ProductDTO> products = productService.getProductsBySeller(sellerId);
        return ResponseEntity.ok(ProductResponse.builder()
                .success(true)
                .data(products)
                .build());
    }

    @GetMapping("/health")
    public ResponseEntity<String> healthCheck() {
        return ResponseEntity.ok("Product Service is running!");
    }
}