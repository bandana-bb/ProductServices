package dev.bandana.productservices.repositories;

import dev.bandana.productservices.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository  extends JpaRepository <Category, Integer>{

    Category findByTitle(String title);//JPA method
    /*
    * select * from category where title like 'title'
    *
    * convert the row to category object and return
    * */

    Optional<Category> findById(int id);
}
