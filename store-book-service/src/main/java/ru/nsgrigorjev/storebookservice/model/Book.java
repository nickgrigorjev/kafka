package ru.nsgrigorjev.creationbookservice.model;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class Book {
    private String id;
    private String name;
    private String description;
    private String status;
    private BigDecimal price;


    @Builder
    public Book(String id, String name, String description, String status, BigDecimal price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.status = status;
        this.price = price;
    }
}
