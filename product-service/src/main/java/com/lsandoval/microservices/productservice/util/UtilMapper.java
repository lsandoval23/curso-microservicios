package com.lsandoval.microservices.productservice.util;

import com.lsandoval.microservices.productservice.model.dto.ProductDTO;
import com.lsandoval.microservices.productservice.model.entity.ProductEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

// Clase Utilitaria para mapear de DTO al entity
@Component
public class UtilMapper {

    public ProductEntity convertDTOtoEntity(ProductDTO productDTO){
        ProductEntity productEntity = ProductEntity.builder().build();
        BeanUtils.copyProperties(productDTO, productEntity);
        return  productEntity;
    }

    public ProductDTO convertEntitytoDTO(ProductEntity productEntity){
        ProductDTO productDTO = ProductDTO.builder().build();
        BeanUtils.copyProperties(productEntity, productDTO);
        return  productDTO;
    }




}
