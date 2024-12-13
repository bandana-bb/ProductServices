package dev.bandana.productservices.repositories;

import dev.bandana.productservices.models.Category;
import dev.bandana.productservices.models.Product;
import dev.bandana.productservices.projections.ProductProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Product save(Product product);


    List<Product> finadAll();

    @Override
    Page<Product> findAll(Pageable pageable);

    Optional<Product> findAllById(long id);
    List<Product> findByCategory(Category category);

    List<Product> findAllByCategory_Title(String categoryTitle);

    //multiple and
    List<Product> findByTitleStartingWithAndIdEqualsAndPriceLessThan(String title, int id, double price);

   //Hql example
    @Query("select p.title as title, p.id as id from Product p where p.category.title = :categoryName")
    List<ProductProjection> getTitlesAndIdOfAllProductsWithGivenCategoryName(@Param("categoryName") String categoryName);


    //native query

    @Query(value = "select * from products p where p.id = 1 and p.title = :productTitle", nativeQuery = true)
    List<ProductProjection> getTitlesAndIdOfAllProductsWithCategoryNameEquals(@Param("productTitle") String productTitle);


}
