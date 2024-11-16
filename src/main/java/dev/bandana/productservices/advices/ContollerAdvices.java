package dev.bandana.productservices.advices;

import dev.bandana.productservices.dtos.ErrorDTO;
import dev.bandana.productservices.exceptions.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ContollerAdvices {
    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ErrorDTO> handleProductNotFoundExceptio(ProductNotFoundException productNotFoundException) {
        ErrorDTO errorDTO = new ErrorDTO();
        errorDTO.setMessage(productNotFoundException.getMessage());

        ResponseEntity<ErrorDTO> responseEntity=new ResponseEntity<>(errorDTO, HttpStatus.NOT_FOUND);
        return responseEntity;
    }
}
