package com.lsandoval.microservices.clientservice.service;

import com.lsandoval.microservices.clientservice.model.request.ProductDTO;
import com.lsandoval.microservices.clientservice.proxy.openfeign.CloudGatewayFeign;
import com.lsandoval.microservices.clientservice.proxy.openfeign.ProductFeign;
import com.lsandoval.microservices.clientservice.proxy.resttemplate.CloudGatewayRestTemplate;
import com.lsandoval.microservices.clientservice.proxy.resttemplate.ProductRestTemplate;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ClientService {

    // private final ProductRestTemplate productRestTemplate;
    //private final CloudGatewayRestTemplate cloudGatewayRestTemplate;
    // private final ProductFeign productFeign;

    private final CloudGatewayFeign cloudGatewayFeign;
    // Clase que nos permite generar circuitos para cada request.
    private final CircuitBreakerFactory circuitBreakerFactory;

    /*public List<ProductDTO> getAllProducts(){
        return cloudGatewayFeign.getAllProducts();
    }*/

    public List<ProductDTO> getAllProducts(){

        // El id es el nombre que se le da al circuito, el metodo run acepta el camino del circuito cerrado y el fallback como parametros
        // En este caso, el primero es cloudGatewayFeign.getAllProducts() y el segundo getAlternativeProducts()
        return circuitBreakerFactory.create("mitocode")
                .run( () -> cloudGatewayFeign.getAllProducts() ,
                      e ->  getAlternativeProducts(e) );
    }

    public ProductDTO saveProduct(ProductDTO productDTO){
        return cloudGatewayFeign.saveProduct(productDTO);
    }

    private List<ProductDTO> getAlternativeProducts(Throwable e){

        log.info(e.getMessage());
        List<ProductDTO> lstProducts = new ArrayList<>();
        ProductDTO productDTO = ProductDTO.builder()
                .productId("P9999")
                .productName("Product Fake")
                .productType("Fake")
                .stock(5)
                .build();

        lstProducts.add(productDTO);

        return  lstProducts;
    }



}
