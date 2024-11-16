package dev.bandana.productservices.services;

import dev.bandana.productservices.exceptions.ProductNotFoundException;
import dev.bandana.productservices.models.Category;
import dev.bandana.productservices.models.Product;

import java.util.List;

public interface ProductServices {
    List<Product> getAllProducts();
    List<String> getAllCategory();
    Product getSingleProduct(long id) throws ProductNotFoundException;
    Product CreateProduct(String title,String description,double price,String category,String imageUrl );
    Product UpdateProduct(String title, String description, double price, String category, String imageUrl, int id);
}
