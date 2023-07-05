package com.shop.app.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
@Document(collection = "product")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    private Long productId;
    private String name;
    private String code;
    private Long categoryId;
    private BigDecimal price;
}
