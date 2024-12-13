package dev.bandana.productservices.services;

import dev.bandana.productservices.exceptions.ProductNotFoundException;
import dev.bandana.productservices.models.Product;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface ProductServices {
    public List<Product> getProductPaginated(@RequestParam("pageNo") int pageNo, @RequestParam("pageSize") int pageSize);
    List<Product> getAllProducts();
    List<Product> getAllCategory();
    Product getSingleProduct(long id) throws ProductNotFoundException;
    Product CreateProduct(String title,String description,double price,String category,String imageUrl );
    Product UpdateProduct(String title, String description, double price, String category, String imageUrl, int id);
}
