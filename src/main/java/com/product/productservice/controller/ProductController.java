package com.product.productservice.controller;


import com.product.productservice.commons.AuthenticationCommons;
import com.product.productservice.dtos.UserDto;
import com.product.productservice.exception.InvalidProductException;
import com.product.productservice.model.Product;
import com.product.productservice.model.ProductDTO;
import com.product.productservice.service.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    ProductService productService;
    private final AuthenticationCommons authenticationCommons;

    public ProductController(@Qualifier("fakeProductServiceImpl") ProductService productService, AuthenticationCommons authenticationCommons) {
        this.productService = productService;
        this.authenticationCommons = authenticationCommons;
    }

    @GetMapping("/getAll/{token}")
    public ResponseEntity<List<Product>> getAllProducts(@PathVariable String token) {
        UserDto userDto = authenticationCommons.validateToken(token);
        if(userDto == null) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        return ResponseEntity.accepted().body(productService.getAllProducts());
    }

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable long id) throws InvalidProductException {
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
