package dev.bandana.productservices.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Category extends BaseModel {
    private String title;
    //@OneToMany(mapped by ="category",cascade={CascadeType.REMOVE})--this will help to add create another
    //table for both ids
    @OneToMany
    List<Product> products;

}
