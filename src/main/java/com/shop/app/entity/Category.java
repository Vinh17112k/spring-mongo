package com.shop.app.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Document(collection = "category")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Category {
    private Long categoryId;
    private String name;
    private String code;
}
