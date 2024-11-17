package dev.bandana.productservices.repositories;

import dev.bandana.productservices.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Product save(Product product);
}
