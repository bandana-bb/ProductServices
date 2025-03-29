package dev.bandana.productservices.controllers;

import dev.bandana.productservices.exceptions.ProductNotFoundException;
import dev.bandana.productservices.models.Product;
import dev.bandana.productservices.services.ProductServices;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class ProductControllerTest {

    @Autowired
    private ProductController productController;

    @MockBean
    private ProductServices productServices;


    @Test
    void getAllProducts() {
    }

    @Test
    void getSingleProductPositive() throws ProductNotFoundException {

        Product expectedProduct = new Product();
        expectedProduct.setTitle("iphpme12");
        expectedProduct.setPrice(23722.2);



        when(productServices.getSingleProduct(1)).thenReturn(expectedProduct);

        Product actualProduct = productController.getSingleProduct(1).getBody();

        assertEquals(expectedProduct, actualProduct);
    }

   @Test
    void getSingleProductNegative() throws ProductNotFoundException {
        when(productServices.getSingleProduct(-1L)).thenThrow(ProductNotFoundException.class);

        assertThrows(ProductNotFoundException.class, () -> productController.getSingleProduct(-1));
    }

    void testGetSingleProductTimeout() throws ProductNotFoundException {
        Product expectedProduct = new Product();
        expectedProduct.setTitle("iphpme12");
        expectedProduct.setPrice(23722.2);
        expectedProduct.setImageUrl("zvyd");
        when(productServices.getSingleProduct(1)).thenReturn(expectedProduct);

        assertTimeout(Duration.ofMillis(1000),() -> productController.getSingleProduct(1));
    }
    @Test
    void getAllCategory() {
    }

    @Test
    void createProduct() {
    }

    @Test
    void updateProduct() {
    }

    @Test
    void getProductPaginated() {
    }
}