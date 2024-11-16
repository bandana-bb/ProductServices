package dev.bandana.productservices;

import dev.bandana.productservices.models.Product;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProductServicesApplication {

    public static void main(String[] args) {
        Product p=new Product();
        SpringApplication.run(ProductServicesApplication.class, args);
    }

}
