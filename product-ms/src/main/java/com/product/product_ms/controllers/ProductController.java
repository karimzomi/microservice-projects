package com.product.product_ms.controllers;

import java.util.List;
import java.util.UUID;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.product.product_ms.cqrs.CreateProductCommand;
import com.product.product_ms.entities.Product;
import com.product.product_ms.services.ProductService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;

@RestController
@RequestMapping("products")
public class ProductController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ProductService productService;

    @GetMapping("/all")
    @Retry(name = "myRetry", fallbackMethod = "fallback")
    @RateLimiter(name = "myRateLimiter", fallbackMethod = "fallback")
    @CircuitBreaker(name = "productmicroService", fallbackMethod = "fallback")
    public List<Product> findAll() {
        return productService.findAll();
    }

    @Autowired
    private CommandGateway commandGateway;

    @PostMapping
    public String createProduct(@RequestBody Product product) {
        String id = UUID.randomUUID().toString();
        CreateProductCommand command = new CreateProductCommand(
                id, product.getName(), product.getDescription(), product.getPrice(),
                product.getStock());
        commandGateway.sendAndWait(command);
        product.setId(id);
        productService.save(product);
        return id;
    }

    public String fallback(Exception e) {
        return "Service is down, please try again later";
    }

    @GetMapping("/find/{id}")
    public Product findById(@PathVariable String id) {
        return productService.findById(id);
    }

    @PostMapping("/save")
    public Product save(@PathVariable String name, @PathVariable String password) {
        Product product = Product.builder().name(name).description("")
                .price(0).stock(0).build();
        return productService.save(product);
    }

    @GetMapping("/delete")
    public void deleteById(@PathVariable String id) {
        productService.deleteById(id);
    }

    @GetMapping("/users")
    public String getUsers() {
        String userServiceUrl = "http://user-ms/users/all";
        return restTemplate.getForObject(userServiceUrl, String.class);
    }

}
