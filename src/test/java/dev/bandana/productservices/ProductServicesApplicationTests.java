package dev.bandana.productservices;

import dev.bandana.productservices.exceptions.ProductNotFoundException;
import dev.bandana.productservices.models.Product;
import dev.bandana.productservices.projections.ProductProjection;
import dev.bandana.productservices.repositories.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductServicesApplicationTests {
    @Autowired
    ProductRepository productRepository;
    @Test
    void contextLoads() {
    }

    @Test
    void testingQueries(){
//      List<ProductProjection> productProjections = productRepository.getTitlesAndIdOfAllProductsWithGivenCategoryName("electronics");
//
//
//              for(ProductProjection productProjection : productProjections){
//                  System.out.println(productProjection.getTitle());
//                  System.out.println(productProjection.getId());
//              }
//
//        System.out.println();
//        List<Product> productList=productRepository.findAllByCategory_Title("electronics");
//        System.out.println(productList);
    }
    @Test
    public void testAddition(){

        //A-Arrange, A-Act, A-Assert

        //Arrange
        int a=2;
        int b=3;
        //Act
        int result=a+b;

        //Assert
      //  assert result==5;

//        assertEquals(result,5);
//        assertNull(obj); if obj==null :pass,else fail;
//        assertNotNull(obj);
//        assertTimeout(Duration.ofMillis(1000),()->productRepository.findById(10L));
//        assertThrows(ProductNotFoundException.class, ()->productRepository.findById(10L));



    }


}
