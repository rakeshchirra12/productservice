package com.product.productservice;

import com.product.productservice.model.Product;
import com.product.productservice.model.Projection;
import com.product.productservice.repository.CategoryRepository;
import com.product.productservice.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class ProductserviceApplicationTests {
	@Autowired
	ProductRepository productRepository;
	@Autowired
	CategoryRepository categoryRepository;


	@Test
	void contextLoads() {
	}
	@Test
	void testing() {
		List<Product> products = productRepository.findByHPAQuery();
		System.out.println(products);
		Projection projection = productRepository.projection();
		System.out.println(projection.getId());
		System.out.println(projection.getTitle());
		Product product = productRepository.nativeQuery();
		System.out.println(product);
		categoryRepository.deleteById(2L);
		System.out.println("test");
	}


}
