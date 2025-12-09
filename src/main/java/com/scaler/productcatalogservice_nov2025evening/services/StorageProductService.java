package com.scaler.productcatalogservice_nov2025evening.services;

import com.scaler.productcatalogservice_nov2025evening.models.Product;
import com.scaler.productcatalogservice_nov2025evening.models.State;
import com.scaler.productcatalogservice_nov2025evening.repos.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("sps")   // sps is customized name you can give to your bean
//@Primary   since Qualifier is used in controller.
public class StorageProductService implements IProductService{

    @Autowired
    private ProductRepo productRepo;

    @Override
    public Product getProductById(Long id) {
        Optional<Product> productOptional = productRepo.findById(id);
        if(productOptional.isPresent()) {
            return productOptional.get();
        }
        return null;
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }

    @Override
    public Product createProduct(Product product) {
        return productRepo.save(product);
    }

    @Override
    public Product replaceProduct(Long id, Product input) {
        Optional<Product> optionalProduct = productRepo.findById(id);
        if(optionalProduct.isPresent()) {
            input.setId(id);   //since id is getting passed in the method, if in put operation if user has not provided id then it will throw a error.
            return productRepo.save(input);
        }
        return null;
    }
    @Override
    public void deleteProduct(Long id) {
        Optional<Product> optionalProduct = productRepo.findById(id);
        if(optionalProduct.isPresent()) {
            Product product = optionalProduct.get();
            if(product.getState().equals(State.ACTIVE)){
                product.setState(State.DELETED);
                productRepo.save(product);
            }else{
                productRepo.deleteById(id);
            }

        }
    }
}
