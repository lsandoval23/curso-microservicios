package com.lsandoval.microservices.clientservice.service;

import com.lsandoval.microservices.clientservice.model.request.ProductDTO;
import com.lsandoval.microservices.clientservice.proxy.openfeign.CloudGatewayFeign;
import com.lsandoval.microservices.clientservice.proxy.openfeign.ProductFeign;
import com.lsandoval.microservices.clientservice.proxy.resttemplate.CloudGatewayRestTemplate;
import com.lsandoval.microservices.clientservice.proxy.resttemplate.ProductRestTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientService {

    // private final ProductRestTemplate productRestTemplate;
    //private final CloudGatewayRestTemplate cloudGatewayRestTemplate;
    private final ProductFeign productFeign;
    // private final CloudGatewayFeign cloudGatewayFeign;

    public List<ProductDTO> getAllProducts(){
        return productFeign.getAllProducts();
    }

    public ProductDTO saveProduct(ProductDTO productDTO){
        return productFeign.saveProduct(productDTO);
    }



}
