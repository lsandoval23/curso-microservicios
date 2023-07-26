package com.lsandoval.microservices.clientservice.proxy.openfeign;

import com.lsandoval.microservices.clientservice.model.request.ProductDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

// Con esta anotacion indicamos hacia que servicio estaremos haciendo las consultas. El nombre es el que tiene registrado
// dentro de Eureka Server
@FeignClient(name = "product-service")
public interface ProductFeign {

    // Mapeamos la misma ruta que tiene el controlador dentro de product-service,
    // la respuesta de esa ruta se mapea a la funcion de la interfaz
    @GetMapping("/product")
    List<ProductDTO> getAllProducts();  // Cuando llame a este metodo, estare llamando a la ruta /product dentro de product-service

    @PostMapping("/product")
    ProductDTO saveProduct(@RequestBody ProductDTO productDTO);

}
