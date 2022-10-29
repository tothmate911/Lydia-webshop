package com.lydiawebshop.webproject.product.service;

import com.lydiawebshop.webproject.product.model.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ActiveProfiles(profiles = "test")
class ProductServiceImplTest {

    @Autowired
    private ProductService productService;

    @Test
    public void saveProduct_productSavedInDatabase() {
        Product product1 = Product.builder()
                .name("Product1")
                .prize(20L)
                .build();
        productService.saveProduct(product1);

        List<Product> products = productService.getProducts();
        assertEquals(1, products.size());

        Product resultProduct = products.get(0);
        assertEquals("Product1", resultProduct.getName());
        assertEquals(20L, resultProduct.getPrize());
    }

}
