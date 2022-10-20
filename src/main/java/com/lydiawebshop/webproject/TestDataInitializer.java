package com.lydiawebshop.webproject;

import com.lydiawebshop.webproject.product.model.Product;
import com.lydiawebshop.webproject.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class TestDataInitializer implements ApplicationRunner {

    @Autowired
    private ProductService productService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Product product1 = Product.builder()
                .name("Product1")
                .prize(10000L)
                .build();
        productService.save(product1);
    }
}
