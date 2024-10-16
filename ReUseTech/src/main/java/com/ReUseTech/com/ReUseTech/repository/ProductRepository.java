package com.ReUseTech.com.ReUseTech.repository;


import com.ReUseTech.com.ReUseTech.dto.ProductDTO;
import com.ReUseTech.com.ReUseTech.model.Comment;
import com.ReUseTech.com.ReUseTech.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

}