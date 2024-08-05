package com.product.productservice.service;

import com.product.productservice.exception.InvalidProductException;
import com.product.productservice.model.Product;
import com.product.productservice.model.ProductDTO;
import com.product.productservice.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service("selfProductServiceImpl")
public class SelfProductServiceImpl implements ProductService {
    ProductRepository productRepository;

    public SelfProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product getProduct(Long id) throws InvalidProductException {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if(optionalProduct.isEmpty()) {
            throw new InvalidProductException("Product empty");
        }
        return optionalProduct.get();
    }

    @Override
    public Product createproduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product updateproduct(Long id, ProductDTO productDTO) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if(optionalProduct.isEmpty()) {
            throw new RuntimeException("Product empty");
        }
        Product product = optionalProduct.get();
        if(productDTO.getDescription() != null)  {
            product.setDescription(productDTO.getDescription());
        }
        if(productDTO.getTitle() != null)  {
            product.setTitle(productDTO.getTitle());
        }
        if(productDTO.getPrice() != null)  {
            product.setPrice(productDTO.getPrice());
        }
        if(productDTO.getCategory() != null)  {
            product.getCategory().setName(productDTO.getDescription());
        }
        return productRepository.save(product);
    }

    @Override
    public Product replaceProduct(Long id, Product product) {
        return productRepository.save(product);
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
}
