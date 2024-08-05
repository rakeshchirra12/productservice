package com.product.productservice.service;


import com.product.productservice.exception.InvalidProductException;
import com.product.productservice.model.Product;
import com.product.productservice.model.ProductDTO;

import java.util.List;

public interface ProductService {
    Product getProduct(Long id) throws InvalidProductException;
    Product createproduct(Product product);
    Product updateproduct(Long id, ProductDTO productDTO);
    Product replaceProduct(Long id, Product product);
    void deleteProduct(Long id);

    List<Product> getAllProducts();
}
