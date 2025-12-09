package com.scaler.productcatalogservice_nov2025evening.services;

import com.scaler.productcatalogservice_nov2025evening.models.Product;

import java.util.List;

public interface IProductService {

    Product getProductById(Long id);

    List<Product> getAllProducts();

    Product createProduct(Product product);

    Product replaceProduct(Long id, Product input);

    void deleteProduct(Long id);
}
