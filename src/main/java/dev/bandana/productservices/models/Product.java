package dev.bandana.productservices.models;


import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Product extends BaseModel {
    private String title;
    private String description;
    private double price;
    @ManyToOne
    //@ManyToOne(Cascade ={CascadeType.PERSIST})
    private Category category;
    private String imageUrl;
}
