package com.lsandoval.microservices.productservice.exposure.web;

import com.lsandoval.microservices.productservice.model.dto.ProductDTO;
import com.lsandoval.microservices.productservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class ProductController {

    private final ProductService productService;

    @GetMapping("/product")
    public ResponseEntity<List<ProductDTO>> getAllProducts() throws InterruptedException {
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @PostMapping("/product")
    public ResponseEntity<ProductDTO> saveProduct(@RequestBody ProductDTO productDTO){
        return ResponseEntity.ok(productService.saveProduct(productDTO));
    }


}
