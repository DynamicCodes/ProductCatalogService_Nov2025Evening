package com.scaler.productcatalogservice_nov2025evening.controllers;

import com.scaler.productcatalogservice_nov2025evening.dtos.CategoryDto;
import com.scaler.productcatalogservice_nov2025evening.dtos.ProductDto;
import com.scaler.productcatalogservice_nov2025evening.exceptions.ProductNotFoundException;
import com.scaler.productcatalogservice_nov2025evening.models.Category;
import com.scaler.productcatalogservice_nov2025evening.models.Product;
import com.scaler.productcatalogservice_nov2025evening.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private IProductService productService;

    @GetMapping
    public List<Product> getAllProducts(){
        Product product1 = new Product();
        product1.setId(1L);
        product1.setName("iphone");
        product1.setDescription("iphone 16 pro");
        product1.setPrice(15.0);
        List<Product> products = new ArrayList<Product>();
        products.add(product1);
        return products;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> getProductById(@PathVariable Long id){

            if (id <= 0) {
                throw new IllegalArgumentException("Id must be greater than 0");
            }
            Product product = productService.getProductById(id);
            if (product != null) {
                ProductDto resp = from(product);
                return new ResponseEntity<>(resp, HttpStatus.OK);
            } else {
                throw new ProductNotFoundException("Product with id > 20 not found");
            }

    }
    @PostMapping
    public ProductDto createProduct(@RequestBody ProductDto productDto){
        return productDto;
    }

    @PutMapping("/{id}")
    public ProductDto replaceProduct(@PathVariable Long id,@RequestBody ProductDto productDto){
        Product product = productService.replaceProduct(id, from(productDto));
        return from(product);
    }

    private ProductDto from(Product product){
        ProductDto productDto = new ProductDto();
        productDto.setId(product.getId());
        productDto.setName(product.getName());
        productDto.setDescription(product.getDescription());
        productDto.setPrice(product.getPrice());
        productDto.setImageUrl(product.getImageUrl());
        if(product.getCategory() != null){
            CategoryDto categoryDto = new CategoryDto();
            categoryDto.setId(product.getCategory().getId());
            categoryDto.setName(product.getCategory().getName());
            categoryDto.setDescription(product.getCategory().getDescription());
            productDto.setCategory(categoryDto);
        }
        return productDto;
    }
    private Product from(ProductDto productDto){
        Product product = new Product();
        product.setId(productDto.getId());
        product.setName(productDto.getName());
        product.setDescription(productDto.getDescription());
        product.setPrice(productDto.getPrice());
        product.setImageUrl(productDto.getImageUrl());
        if(productDto.getCategory() != null){
            Category category = new Category();
            category.setId(productDto.getCategory().getId());
            category.setName(productDto.getCategory().getName());
            category.setDescription(productDto.getCategory().getDescription());
            product.setCategory(category);
        }
        return product;
    }




}
