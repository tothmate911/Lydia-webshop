package com.lydiawebshop.webproject;

import com.lydiawebshop.webproject.product.model.Product;
import com.lydiawebshop.webproject.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("development")
public class DevelopmentTestDataInitializer implements ApplicationRunner {

    @Autowired
    private ProductService productService;

    @Override
    public void run(ApplicationArguments args) {
        Product product1 = Product.builder()
                .name("Product1")
                .prize(10000L)
                .build();
        productService.saveProduct(product1);
    }

}
