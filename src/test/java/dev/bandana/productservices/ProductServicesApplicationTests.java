package dev.bandana.productservices;

import dev.bandana.productservices.models.Product;
import dev.bandana.productservices.projections.ProductProjection;
import dev.bandana.productservices.repositories.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class ProductServicesApplicationTests {
    @Autowired
    ProductRepository productRepository;
    @Test
    void contextLoads() {
    }

    @Test
    void testingQueries(){
      List<ProductProjection> productProjections = productRepository.getTitlesAndIdOfAllProductsWithGivenCategoryName("electronics");


              for(ProductProjection productProjection : productProjections){
                  System.out.println(productProjection.getTitle());
                  System.out.println(productProjection.getId());
              }

        System.out.println();
//        List<Product> productList=productRepository.findAllByCategory_Title("electronics");
//        System.out.println(productList);
    }


}
