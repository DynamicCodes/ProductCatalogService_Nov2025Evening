package com.scaler.productcatalogservice_nov2025evening.services;

import com.scaler.productcatalogservice_nov2025evening.dtos.FakeStoreProductDto;
import com.scaler.productcatalogservice_nov2025evening.dtos.ProductDto;
import com.scaler.productcatalogservice_nov2025evening.models.Category;
import com.scaler.productcatalogservice_nov2025evening.models.Product;
import jakarta.annotation.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
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
        ResponseEntity<FakeStoreProductDto> fakeStoreProductDtoResponseEntity =
                requestForEntity("http://fakestoreapi.com/products/{id}",null, HttpMethod.GET, FakeStoreProductDto.class, id);

        if(fakeStoreProductDtoResponseEntity.getStatusCode().equals(HttpStatus.valueOf(200))
        && (fakeStoreProductDtoResponseEntity.getBody() != null)) {
            return from(fakeStoreProductDtoResponseEntity.getBody());
        }


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
        FakeStoreProductDto fakeStoreProductDto = from(input);
        ResponseEntity<FakeStoreProductDto> fakeStoreProductDtoResponseEntity =
                requestForEntity("http://fakestoreapi.com/products/{id}",fakeStoreProductDto, HttpMethod.PUT, FakeStoreProductDto.class, id);

        return from(fakeStoreProductDtoResponseEntity.getBody());
    }

    private Product from(FakeStoreProductDto fakeStoreProductDto) {
        Product product = new Product();
        product.setId(fakeStoreProductDto.getId());
        product.setName(fakeStoreProductDto.getTitle());
        product.setDescription(fakeStoreProductDto.getDescription());
        product.setPrice(fakeStoreProductDto.getPrice());
        product.setImageUrl(fakeStoreProductDto.getImage());
        Category category = new Category();
        product.setCategory(category);
        return product;
    }
    private FakeStoreProductDto from(Product product) {
        FakeStoreProductDto fakeStoreProductDto = new FakeStoreProductDto();
        fakeStoreProductDto.setId(product.getId());
        fakeStoreProductDto.setTitle(product.getName());
        fakeStoreProductDto.setDescription(product.getDescription());
        fakeStoreProductDto.setPrice(product.getPrice());
        fakeStoreProductDto.setImage(product.getImageUrl());
        if(product.getCategory() != null) {
            fakeStoreProductDto.setCategory(product.getCategory().getName());
        }
        return fakeStoreProductDto;
    }
}
