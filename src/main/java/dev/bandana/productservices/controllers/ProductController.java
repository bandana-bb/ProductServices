package dev.bandana.productservices.controllers;

import dev.bandana.productservices.dtos.CreateProductRequestDto;
import dev.bandana.productservices.dtos.UpdateProductRequestDto;
import dev.bandana.productservices.exceptions.ProductNotFoundException;
import dev.bandana.productservices.models.Product;
import dev.bandana.productservices.services.ProductServices;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    public ProductServices productServices;

    ProductController(@Qualifier("selfProductService") ProductServices productServices) {

        this.productServices = productServices;
    }
    /*
     * Api= method in my controller
     * */

    /**
     * GET /Product/
     */
    @RequestMapping("/products")
    public List<Product> getAllProducts(){
        return  productServices.getAllProducts();
    }
    /*
     * GET /products/{id}
     * */

    //Without Response entity
//    @RequestMapping("/products/{id}")
//    public Product getSingleProduct(@PathVariable("id") int id){
//        return productServices.getSingleProduct(id);
//    }


    //with Response entity


    @RequestMapping("/products/{id}")
    public ResponseEntity<Product> getSingleProduct(@PathVariable("id") int id) throws ProductNotFoundException {
        Product p=productServices.getSingleProduct(id);
        ResponseEntity<Product>  responseEntity_1;
        if(p==null){
            responseEntity_1= new ResponseEntity<>(p, HttpStatus.NOT_FOUND);
        }
        else{
            responseEntity_1= new ResponseEntity<>(p,HttpStatus.OK);
        }

        return responseEntity_1;

    }


    //*********Get all Category ***************


    @RequestMapping("/products/categories")
    public List<String> getAllCategory(){
        return productServices.getAllCategory();
    }



    /*
     *  *************************Create a product
     *{
     * title:
     * description:
     * price:
     * category:
     *
     * POST /products/
     *  ******************************************************************/

    @PostMapping("/products")
    public Product createProduct(@RequestBody CreateProductRequestDto createProductRequestDto){
        return productServices.CreateProduct(createProductRequestDto.getTitle(),
                createProductRequestDto.getDescription(),
                createProductRequestDto.getPrice(),createProductRequestDto.getCategory()
                ,createProductRequestDto.getImage());
    }

    //Update a product
    @PutMapping("/products/{id}")
    public  Product UpdateProduct(@RequestBody UpdateProductRequestDto updateProductRequestDto, @PathVariable("id") int id) {
        return productServices.UpdateProduct(updateProductRequestDto.getTitle(), updateProductRequestDto.getDescription(),
                updateProductRequestDto.getPrice(), updateProductRequestDto.getCategory(), updateProductRequestDto.getImage(),
                id);

    }

//    @ExceptionHandler(ProductNotFoundException.class)
//    public ResponseEntity<ErrorDTO> handleProductNotFoundExceptio(ProductNotFoundException productNotFoundException) {
//        ErrorDTO errorDTO = new ErrorDTO();
//        errorDTO.setMessage(productNotFoundException.getMessage());
//
//        ResponseEntity<ErrorDTO> responseEntity=new ResponseEntity<>(errorDTO, HttpStatus.NOT_FOUND);
//        return responseEntity;
//    }
}
