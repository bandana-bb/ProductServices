package dev.bandana.productservices.services;

import dev.bandana.productservices.exceptions.ProductNotFoundException;
import dev.bandana.productservices.models.Category;
import dev.bandana.productservices.models.Product;
import dev.bandana.productservices.repositories.CategoryRepository;
import dev.bandana.productservices.repositories.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("selfProductService")
public class SelfProductService implements ProductServices{


    public Page<Product> getAllProductsPaginated(int pageNo, int pageSize) {
        return  productRepository.findAll(
                PageRequest.of(pageNo, pageSize)
        );
    }
    private CategoryRepository categoryRepository;

    private ProductRepository productRepository;

    public SelfProductService(CategoryRepository categoryRepository,ProductRepository productRepository) {
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getProductPaginated(int pageNo, int pageSize) {
        return (List<Product>) productRepository.findAll(PageRequest.of(pageNo,pageSize, Sort.by("title").descending()));
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> getAllCategory() {
        return productRepository.findAllByCategory_Title("electronics");
    }

    @Override
    public Product getSingleProduct(long id) throws ProductNotFoundException {
        Optional<Product> product = productRepository.findAllById(id);
        if(product.isEmpty()){
            throw new ProductNotFoundException("Product with id "+id+" not found");
        }
        return product.get();
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
