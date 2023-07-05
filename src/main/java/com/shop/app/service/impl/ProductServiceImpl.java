package com.shop.app.service.impl;

import com.shop.app.domain.product.ProductDTO;
import com.shop.app.entity.Product;
import com.shop.app.mapper.ProductMapper;
import com.shop.app.repository.ProductRepository;
import com.shop.app.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductMapper productMapper;
    private final ProductRepository productRepository;
    @Override
    public ProductDTO createProduct(ProductDTO productDTO) {
        Product product = productMapper.toEntity(productDTO);
        return productMapper.toDto(productRepository.save(product));
    }
}
