package com.scaler.productcatalogservice_nov2025evening.repos;

import com.scaler.productcatalogservice_nov2025evening.models.Category;
import com.scaler.productcatalogservice_nov2025evening.models.Product;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class CategoryRepoTest {

    @Autowired
    private CategoryRepo categoryRepo;

    @Test
    @Transactional
    public void testFetchTypes(){
        Category category = categoryRepo.findById(10L).get();
        System.out.println(category.getName());
        for(Product product : category.getProducts()){
            System.out.println(product.getName());
        }
    }
    @Test
    @Transactional
    public void testNPlusOne(){
        List<Category> categoryList = categoryRepo.findAll();
        for(Category category : categoryList){
            System.out.println(category.getName());
            for(Product product : category.getProducts()){
                System.out.println(product.getName());
            }
        }
    }
}