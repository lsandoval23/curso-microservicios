package com.lsandoval.microservices.clientservice.proxy;

import com.lsandoval.microservices.clientservice.model.request.ProductDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Objects;

@Component
@RequiredArgsConstructor
public class ProductRestTemplate {

    private final RestTemplate restTemplate;

    public List<ProductDTO> getAllProducts(){
        return List.of(Objects
                .requireNonNull(restTemplate.getForObject("http://localhost:9001/product", ProductDTO[].class)));
    }

}
