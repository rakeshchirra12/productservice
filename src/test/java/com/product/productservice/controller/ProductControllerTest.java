package com.product.productservice.controller;

import com.product.productservice.exception.InvalidProductException;
import com.product.productservice.model.Category;
import com.product.productservice.model.Product;
import com.product.productservice.service.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

//@SpringBootTest
class ProductControllerTest {

//    @Autowired
//    private ProductController productController;
//
//    @MockBean
//    @Qualifier("selfProductServiceImpl")
//    private ProductService productService;
//    @Test
//    void getAllProducts() {
//    }

//    @Test
//    void getProduct() throws InvalidProductException {
//        Product product = new Product();
//        product.setId(10L);
//        product.setDescription("Iphone");
//        product.setTitle("Iphone");
//        product.setCategory(new Category());
//        product.setPrice(13000.0);
//
//        when(productService.getProduct(10L)).thenReturn(product);
//        Product actualOutput = productController.getProduct(10L);
//
//        assertEquals(product, actualOutput);
//    }

//    @Test
//    void testProductInvalid() throws InvalidProductException {
//        when(productService.getProduct(1000L)).thenThrow(new InvalidProductException("Invalid product"));
//        assertThrows(InvalidProductException.class, ()->productController.getProduct(1000L));
//    }


    @Test
    void testGetAllProducts() {
//        List<Product> products = new ArrayList<>();
//        when(productService.getAllProducts()).thenReturn(products);
//        assertEquals(products, productController.getAllProducts(""));
    }
}