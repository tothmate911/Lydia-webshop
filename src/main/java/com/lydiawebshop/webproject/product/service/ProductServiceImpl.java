package com.lydiawebshop.webproject.product.service;

import com.lydiawebshop.webproject.product.model.Product;
import com.lydiawebshop.webproject.product.respository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product saveProduct(Product product) {
        log.info("Product saved: " + product);
        return productRepository.save(product);
    }

}
