package com.lsandoval.microservices.clientservice.proxy.openfeign;

import com.lsandoval.microservices.clientservice.model.request.ProductDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "cloud-gateway")
public interface CloudGatewayFeign {

    // Como hacemos referencia al servicio de cloud gateway, las rutas cambian para lo especificado en los archivos de configuraciones
    // de cloud gateway para el servicio product-service.

    @GetMapping("/api/product-service/product")
    List<ProductDTO> getAllProducts();

    @PostMapping("/api/product-service/product")
    ProductDTO saveProduct(@RequestBody ProductDTO productDTO);
}
