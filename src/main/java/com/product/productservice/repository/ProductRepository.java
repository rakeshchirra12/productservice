package com.product.productservice.repository;

import com.product.productservice.model.Product;
import com.product.productservice.model.Projection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Optional<Product> findById(Long id);
   @Query("select p from Product p where p.price >= 100")
    List<Product> findByHPAQuery();
    @Query("select p.id as id, p.title as title from Product p where p.id = 52")
    Projection projection();

    @Query(value = "select * from product where id = 52", nativeQuery = true)
    Product nativeQuery();

}
