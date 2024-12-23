package com.product.product_ms.cqrs;

import lombok.Data;

@Data
public class GetProductByIdQuery {
    private final String id;

    public GetProductByIdQuery(String id) {
        this.id = id;
    }

}