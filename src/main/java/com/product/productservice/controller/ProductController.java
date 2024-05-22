package com.product.productservice.controller;


import com.product.productservice.model.Product;
import com.product.productservice.model.ProductDTO;
import com.product.productservice.service.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    ProductService productService;

    public ProductController(@Qualifier("selfProductServiceImpl") ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable long id) {
        return productService.getProduct(id);
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productService.createproduct(product);
    }

    @PutMapping("/{id}")
    public Product replaceProduct(@PathVariable long id, @RequestBody Product product) {
        return productService.replaceProduct(id, product);
    }

    @PatchMapping("/{id}")
    public Product updateProduct(@PathVariable long id, @RequestBody ProductDTO productDTO) {
        return productService.updateproduct(id,productDTO);
    }
    @DeleteMapping("/{id}")
    public void deleteProductById(@PathVariable long id) {
        productService.deleteProduct(id);
    }
}
