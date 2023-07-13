package com.lsandoval.microservices.productservice.service.repository;

import com.lsandoval.microservices.productservice.model.entity.ProductEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends MongoRepository<ProductEntity, String> {
}
