package com.shop.app.domain.product;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class ProductDTO {
    private Long id;
    @NotBlank(message = "Khong duoc de trong truong ten")
    private String name;
    private String code;
    private Long categoryId;
    private Long price;
}
