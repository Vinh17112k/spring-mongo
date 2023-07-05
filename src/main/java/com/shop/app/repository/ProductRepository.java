package com.shop.app.repository;
import com.shop.app.entity.Product;
import com.shop.app.entity.Task;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface ProductRepository extends MongoRepository<Product,String> {


}