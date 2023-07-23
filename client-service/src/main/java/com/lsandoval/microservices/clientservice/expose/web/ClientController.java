package com.lsandoval.microservices.clientservice.expose.web;

import com.lsandoval.microservices.clientservice.model.request.ProductDTO;
import com.lsandoval.microservices.clientservice.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;

    @GetMapping("/product")
    public ResponseEntity<List<ProductDTO>> getAllProducts(){
        return ResponseEntity.ok(clientService.getAllProducts());
    }


}
