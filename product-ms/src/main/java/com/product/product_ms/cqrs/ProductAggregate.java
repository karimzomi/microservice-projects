package com.product.product_ms.cqrs;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Aggregate
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductAggregate {
    @AggregateIdentifier
    private String id;
    private String name;
    private String description;
    private double price;
    private int stock;

    @CommandHandler
    public ProductAggregate(CreateProductCommand command) {
        // Publier un événement
        AggregateLifecycle.apply(new ProductCreatedEvent(
                command.getId(),
                command.getName(),
                command.getDescription(),
                command.getPrice(),
                command.getStock()));
    }

    @EventSourcingHandler
    public void on(ProductCreatedEvent event) {
        this.id = event.getId();
        this.name = event.getName();
        this.description = event.getDescription();
        this.price = event.getPrice();
        this.stock = event.getStock();

    }
}