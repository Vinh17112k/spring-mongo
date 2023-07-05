package com.shop.app.service;

import com.shop.app.domain.product.ProductDTO;
import com.shop.app.entity.Task;

import java.util.List;

public interface ProductService {
    ProductDTO createProduct(ProductDTO productDTO);
}
