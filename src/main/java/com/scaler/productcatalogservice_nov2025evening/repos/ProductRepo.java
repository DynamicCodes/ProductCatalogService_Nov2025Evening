package com.scaler.productcatalogservice_nov2025evening.repos;

import com.scaler.productcatalogservice_nov2025evening.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepo extends JpaRepository<Product,Long> {
    Optional<Product> findById(Long id);
}
