package com.product.product_ms.cqrs;

import org.axonframework.config.ProcessingGroup;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.product.product_ms.entities.Product;
import com.product.product_ms.repositories.ProductRepository;

@Component
@Service
@ProcessingGroup("productProcessor")
public class ProductProjection {

    @Autowired
    private ProductRepository productRepository;

    @QueryHandler
    public Product handle(GetProductByIdQuery query) {
        return productRepository.findById(query.getId()).orElse(null);
    }
}