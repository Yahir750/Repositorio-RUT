package com.ReUseTech.com.ReUseTech.controller;

import com.ReUseTech.com.ReUseTech.model.Product;
import com.ReUseTech.com.ReUseTech.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Product")
public class ProductController {
    @Autowired
    private ProductRepository ProductRepo;

    @GetMapping("/findAll")
    public List<Product> getAllStudent(){
        return ProductRepo.findAll();
    }

    @PostMapping("/insert")
    public Product insert(@RequestBody Product student){
        return ProductRepo.save(student);
    }
}