package dev.bandana.productservices.services;

import dev.bandana.productservices.exceptions.ProductNotFoundException;
import dev.bandana.productservices.models.Category;
import dev.bandana.productservices.models.Product;
import dev.bandana.productservices.repositories.CategoryRepository;
import dev.bandana.productservices.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("selfProductService")
public class SelfProductService implements ProductServices{

    private CategoryRepository categoryRepository;

    private ProductRepository productRepository;

    public SelfProductService(CategoryRepository categoryRepository,ProductRepository productRepository) {
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
    }
    @Override
    public List<Product> getAllProducts() {
        return List.of();
    }

    @Override
    public List<String> getAllCategory() {
        return List.of();
    }

    @Override
    public Product getSingleProduct(long id) throws ProductNotFoundException {
        return null;
    }

    @Override
    public Product CreateProduct(String title, String description, double price, String category, String imageUrl) {
        Product product = new Product();
        product.setTitle(title);
        product.setDescription(description);
        product.setPrice(price);
        product.setImageUrl(imageUrl);

        Category categoryFromDB = categoryRepository.findByTitle(category);

        if(categoryFromDB == null) {
            Category newCategory = new Category();
            newCategory.setTitle(category);

            categoryFromDB=new Category();
        }
        product.setCategory(categoryFromDB);
        Product createdProduct=productRepository.save(product);
        return createdProduct;
    }

    @Override
    public Product UpdateProduct(String title, String description, double price, String category, String imageUrl, int id) {
        return null;
    }
}
