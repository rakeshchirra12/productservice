package com.product.productservice.service;


import com.product.productservice.model.Product;
import com.product.productservice.model.ProductDTO;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpMessageConverterExtractor;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service("fakeProductServiceImpl")
public class FakeProductServiceImpl implements ProductService {

    RestTemplate restTemplate;
    RedisTemplate<String, Object> redisTemplate;

    public FakeProductServiceImpl(RestTemplate restTemplate, RedisTemplate<String, Object> redisTemplate) {
        this.restTemplate = restTemplate;
        this.redisTemplate = redisTemplate;
    }

    public Product getProductFromDTO(ProductDTO productDTO) {
        return new Product(productDTO);
    }

    @Override
    public Product getProduct(Long id) {
        Product product = (Product) redisTemplate.opsForHash().get("PRODUCTS", "PRODUCT_"+id);
        if(product == null) {
            ProductDTO productDTO = restTemplate.getForObject("https://fakestoreapi.com/products/" + id, ProductDTO.class);
            product = getProductFromDTO(productDTO);
            redisTemplate.opsForHash().put("PRODUCTS", "PRODUCT_"+id, product);
        }
        ResponseEntity<String> response = restTemplate.getForEntity("http://PAYMENTSERVICE/paymentservice/payments/productService", String.class);
        System.out.println(response);
        return product;
    }

    @Override
    public Product createproduct(Product product) {
        return null;
    }

    @Override
    public Product updateproduct(Long id, ProductDTO productDTO) {

        RequestCallback requestCallback = restTemplate.httpEntityCallback(productDTO, ProductDTO.class);
        HttpMessageConverterExtractor<ProductDTO> responseExtractor =
                new HttpMessageConverterExtractor<>(ProductDTO.class, restTemplate.getMessageConverters());
        return new Product(restTemplate.execute("https://fakestoreapi.com/products/"+id, HttpMethod.PATCH, requestCallback, responseExtractor));
    }

    @Override
    public Product replaceProduct(Long id, Product product) {
        return null;
    }

    @Override
    public void deleteProduct(Long id) {

    }

    @Override
    public List<Product> getAllProducts() {
        ProductDTO[] productDTOS = restTemplate.getForObject("https://fakestoreapi.com/products" , ProductDTO[].class);
        List<Product> products = new ArrayList<>();
        for(ProductDTO dto: productDTOS) {
            products.add(getProductFromDTO(dto));
        }
        return products;
    }
}
