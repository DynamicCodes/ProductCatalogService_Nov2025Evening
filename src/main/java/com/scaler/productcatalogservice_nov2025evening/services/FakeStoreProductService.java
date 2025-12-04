package com.scaler.productcatalogservice_nov2025evening.services;

import com.scaler.productcatalogservice_nov2025evening.dtos.FakeStoreProductDto;
import com.scaler.productcatalogservice_nov2025evening.models.Product;
import jakarta.annotation.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class FakeStoreProductService implements IProductService{

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public Product getProductById(Long id) {
        ResponseEntity<FakeStoreProductDto> fakeStoreProductDtoResponseEntity = requestForEntity("http://localhost:8080/products/" + id, Product.class);


        return null;
    }

    private <T> ResponseEntity<T> requestForEntity(String url, @Nullable Object request, HttpMethod httpMethod, Class<T> responseType, Object... uriVariables) throws RestClientException{
        RequestCallback requestCallback = restTemplate.httpEntityCallback(request, responseType);
        ResponseExtractor<ResponseEntity<T>> responseExtractor = restTemplate.responseEntityExtractor(responseType);
        return restTemplate.execute(url, httpMethod, requestCallback, responseExtractor, uriVariables);
    }

    @Override
    public List<Product> getAllProducts() {
        return List.of();
    }

    @Override
    public Product createProduct(Product product) {
        return null;
    }

    @Override
    public Product replaceProduct(Long id, Product input) {
        return null;
    }
}
