package com.product.product_ms.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.product_ms.entities.Product;
import com.product.product_ms.repositories.ProductRepository;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Product findById(String id) {
        return productRepository.findById(id).orElse(null);
    }

    public Product save(Product product) {
        return productRepository.save(product);
    }

    public void deleteById(String id) {
        productRepository.deleteById(id);
    }

    public Product update(String id, Product product) {
        Product entity = productRepository.findById(id).orElse(null);
        if (entity != null) {
            entity.setName(product.getName());
            entity.setDescription(product.getDescription());
            entity.setPrice(product.getPrice());
            entity.setStock(product.getStock());
            return productRepository.save(entity);
        }
        return null;
    }

}
