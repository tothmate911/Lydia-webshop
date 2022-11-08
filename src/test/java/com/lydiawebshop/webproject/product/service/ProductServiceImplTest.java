package com.lydiawebshop.webproject.product.service;

import com.lydiawebshop.webproject.product.model.Product;
import com.lydiawebshop.webproject.product.respository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@ActiveProfiles(profiles = "test")
class ProductServiceImplTest {

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductRepository productRepository;

    @BeforeEach
    public void initEach() {
        productRepository.deleteAll();
    }

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

    @Test
    public void saveProduct_duplicateProductName_throwException() {
        Product product1 = Product.builder()
                .name("ProductName")
                .prize(20L)
                .build();
        productService.saveProduct(product1);

        Product product2 = Product.builder()
                .name("ProductName")
                .prize(30L)
                .build();
        assertThrows(DataIntegrityViolationException.class, () -> productService.saveProduct(product2));
    }

}
