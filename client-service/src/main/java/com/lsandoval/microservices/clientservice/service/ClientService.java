package com.lsandoval.microservices.clientservice.service;

import com.lsandoval.microservices.clientservice.model.request.ProductDTO;
import com.lsandoval.microservices.clientservice.proxy.ProductRestTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientService {

    private final ProductRestTemplate productRestTemplate;

    public List<ProductDTO> getAllProducts(){
        return productRestTemplate.getAllProducts();
    }



}
