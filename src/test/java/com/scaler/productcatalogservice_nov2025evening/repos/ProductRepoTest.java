package com.scaler.productcatalogservice_nov2025evening.repos;

import com.scaler.productcatalogservice_nov2025evening.models.Product;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductRepoTest {

    @Autowired
    private ProductRepo productRepo;

    @Test
    @Transactional
    public void testJpaMethods(){
        productRepo.findById(1L);

        List<Product> productList = productRepo.findProductByPriceBetween(60000D, 100000D);
        System.out.println(productList.size());
        System.out.println(productList.get(0).getPrice());
    }

}