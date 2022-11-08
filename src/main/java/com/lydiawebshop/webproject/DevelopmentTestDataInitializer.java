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
        Product towel = Product.builder()
                .name("Towel")
                .prize(1000L)
                .description("Blue, small towel")
                .mainImagePath("/images/products/development_test_data/Towel.jpg")
                .build();
        productService.saveProduct(towel);

        Product lego = Product.builder()
                .name("Lego")
                .prize(7990L)
                .description("Lego Technique car")
                .mainImagePath("/images/products/development_test_data/Lego.png")
                .build();
        productService.saveProduct(lego);

        Product book = Product.builder()
                .name("Book")
                .prize(5000L)
                .description("Stephen Meyer: Signature in the Cell")
                .mainImagePath("/images/products/development_test_data/Book.png")
                .build();
        productService.saveProduct(book);
    }

}
