package com.lydiawebshop.webproject.product.controller;

import com.lydiawebshop.webproject.product.model.Product;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@ActiveProfiles(profiles = "test")
class ProductControllerTest {

    @LocalServerPort
    private int port;

    @BeforeEach
    private void setup() {
        RestAssured.port = port;
    }

    @Test
    public void saveProduct_productSaved() {
        Product product1 = Product.builder()
                .name("product1")
                .prize(100L)
                .build();
        // Save product
        RestAssured.with().body(product1).contentType(ContentType.JSON)
                .when().post("/products")
                .then().statusCode(HttpStatus.OK.value());
        // Get products
        List<Product> products = RestAssured.when().get("/products")
                .then().statusCode(HttpStatus.OK.value())
                .extract().response().jsonPath().getList("", Product.class);
        // Check result
        assertEquals(1, products.size());
        Product product = products.get(0);
        assertEquals("product1", product.getName());
        assertEquals(100L, product.getPrize());
    }

}