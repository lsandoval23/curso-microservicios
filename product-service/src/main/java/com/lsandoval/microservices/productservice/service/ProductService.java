package com.lsandoval.microservices.productservice.service;

import com.lsandoval.microservices.productservice.model.dto.ProductDTO;
import com.lsandoval.microservices.productservice.model.entity.ProductEntity;
import com.lsandoval.microservices.productservice.service.repository.ProductRepository;
import com.lsandoval.microservices.productservice.util.UtilMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RequiredArgsConstructor
@Service
public class ProductService {

    private final UtilMapper utilMapper;
    private final ProductRepository productRepository;
    @Value("${server.port}")
    private Integer port;

    public List<ProductDTO> getAllProducts() throws InterruptedException {

        TimeUnit.MILLISECONDS.sleep(80L);

        Iterable<ProductEntity> itProducts = productRepository.findAll();
        return StreamSupport.stream(itProducts.spliterator(), false).map( productEntity -> {
            ProductDTO productDTO = utilMapper.convertEntitytoDTO(productEntity);
            productDTO.setPort(port);
            return productDTO;
        }).collect(Collectors.toList());

    }


    public ProductDTO saveProduct(ProductDTO productDTO){
        ProductEntity productEntity = utilMapper.convertDTOtoEntity(productDTO);
        productRepository.save(productEntity);
        productDTO.setPort(port);

        return productDTO;
    }



}
