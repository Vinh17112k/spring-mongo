package com.shop.app.mapper;

import com.shop.app.domain.product.ProductDTO;
import com.shop.app.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;
@Mapper(componentModel = "spring")
public interface ProductMapper extends EntityMapper<ProductDTO, Product> {
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);
//    @Mapping(target = "createdBy", expression = Constants.EXPRESSION.CURRENT_USER)
//    @Mapping(target = "createdDate", expression = Constants.EXPRESSION.CURRENT_DATE)
//    @Mapping(target = "lastUpdatedBy", expression = Constants.EXPRESSION.CURRENT_USER)
//    @Mapping(target = "lastUpdatedDate", expression = Constants.EXPRESSION.CURRENT_DATE)
//    @Mapping(target = "status", constant = Constants.STATUS.ACTIVE_STR)
//    @Mapping(target = "code", expression = "java(templateRequest.getCode().toUpperCase())")
    Product toEntity(ProductDTO productDTO);

}
