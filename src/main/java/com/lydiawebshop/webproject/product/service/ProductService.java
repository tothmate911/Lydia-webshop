package com.lydiawebshop.webproject.product.service;

import com.lydiawebshop.webproject.product.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> getProducts();

    Product saveProduct(Product product);

}
