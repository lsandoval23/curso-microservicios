package com.lsandoval.microservices.clientservice.service;

import com.lsandoval.microservices.clientservice.model.request.ProductDTO;
import com.lsandoval.microservices.clientservice.proxy.openfeign.CloudGatewayFeign;
import com.lsandoval.microservices.clientservice.proxy.openfeign.ProductFeign;
import com.lsandoval.microservices.clientservice.proxy.resttemplate.CloudGatewayRestTemplate;
import com.lsandoval.microservices.clientservice.proxy.resttemplate.ProductRestTemplate;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
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

    /* ===== Sin usar circuit Breaker ===== */

//    public List<ProductDTO> getAllProducts(){
//        return cloudGatewayFeign.getAllProducts();
//    }
//
//    public ProductDTO saveProduct(ProductDTO productDTO){
//        return cloudGatewayFeign.saveProduct(productDTO);
//    }

    /* ===== Circuit Breaker: Usando Metodos Imperativos ===== */

//    public List<ProductDTO> getAllProducts(){
//
//        // El id es el nombre que se le da al circuito, el metodo run acepta el camino del circuito cerrado y el fallback como parametros
//        // En este caso, el primero es cloudGatewayFeign.getAllProducts() y el segundo getAlternativeProducts()
//        return circuitBreakerFactory.create("mitocode")
//                .run( () -> cloudGatewayFeign.getAllProducts() ,
//                      e ->  getAlternativeProducts(e) );
//    }
//
//
//
//    // El identificador "mitocode2" define al circuito, es decir si se usa el mismo identificado en varios metodos y uno pasa a estado abierto. Este estado
//    // afecta a los demás. (Se crea un hilo distinto para cada identificador)
//    public ProductDTO saveProduct(ProductDTO productDTO){
//        return circuitBreakerFactory.create("mitocode2")
//                .run(() -> cloudGatewayFeign.saveProduct(productDTO),
//                        e -> getAlternativeSaveProduct(productDTO, e)); // El metodo alternativo recibe los mismos parametro que el metodo original,
//                                                                        // ademas del throwable
//    }
//
//    private List<ProductDTO> getAlternativeProducts(Throwable e){
//
//        log.info(e.getMessage());
//        List<ProductDTO> lstProducts = new ArrayList<>();
//        ProductDTO productDTO = ProductDTO.builder()
//                .productId("P9999")
//                .productName("Product Fake")
//                .productType("Fake")
//                .stock(5)
//                .build();
//
//        lstProducts.add(productDTO);
//
//        return  lstProducts;
//    }
//
//    private ProductDTO getAlternativeSaveProduct(ProductDTO productDTO, Throwable e) {
//        log.info(e.getMessage());
//
//        ProductDTO newProductDTO = ProductDTO.builder()
//                .productId("P9999")
//                .productName("Product Fake")
//                .productType("Fake")
//                .stock(5)
//                .build();
//
//        return  newProductDTO;
//
//    }

    /* ===== Circuit Breaker: Usando Metodos Declarativos (archivo de propiedades) ===== */

    //@CircuitBreaker(name = "product-cb", fallbackMethod = "getAlternativeProducts")
    public List<ProductDTO> getAllProducts() {
        return cloudGatewayFeign.getAllProducts();
    }

//    private List<ProductDTO> getAlternativeProducts(Throwable e){
//        log.info(e.getMessage());
//        List<ProductDTO> lstProducts = new ArrayList<>();
//        ProductDTO productDTO = ProductDTO.builder()
//                .productId("P9999")
//                .productName("Product Fake")
//                .productType("Fake")
//                .stock(5)
//                .build();
//
//        lstProducts.add(productDTO);
//
//        return  lstProducts;
//    }

    //@CircuitBreaker(name = "product-cb", fallbackMethod = "getAlternativeSaveProduct")
    public ProductDTO saveProduct(ProductDTO productDTO) {
        return cloudGatewayFeign.saveProduct(productDTO);
    }

//    private ProductDTO getAlternativeSaveProduct(ProductDTO productDTO, Throwable e) {
//        log.info(e.getMessage());
//
//        ProductDTO newProductDTO = ProductDTO.builder()
//                .productId("P8888")
//                .productName("Product Fake")
//                .productType("Fake")
//                .stock(5)
//                .build();
//
//        return  newProductDTO;
//
//    }

}
