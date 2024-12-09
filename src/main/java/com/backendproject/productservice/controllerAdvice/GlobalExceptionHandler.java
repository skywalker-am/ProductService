package com.backendproject.productservice.controllerAdvice;

import com.backendproject.productservice.dtos.ExceptionDto;
import com.backendproject.productservice.exceptions.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<ExceptionDto> handleArithmeticException() {
        ExceptionDto exceptionDto = new ExceptionDto();
        exceptionDto.setMessage("Arithmetic Exception occurred");
        exceptionDto.setSolution("Please check the arithmetic operation");

        return new ResponseEntity<>(
                exceptionDto,
                HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler(ArrayIndexOutOfBoundsException.class)
    public ResponseEntity<String> handleArrayIndexOutOfBoundsException() {

        return new ResponseEntity<>(
                "Array Index Out Of Bounds Exception occurred.  Inside the ControllerAdvice.",
                HttpStatus.BAD_REQUEST
        );
    }

//    @ExceptionHandler(NullPointerException.class)
//    public ResponseEntity<String> handleNullPointerException() {
//        ResponseEntity<String> responseEntity = new ResponseEntity<>(
//                "Null Pointer Exception occurred.  Inside the ControllerAdvice.",
//                HttpStatus.BAD_REQUEST
//        );
//
//        return responseEntity;
//    }


    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ExceptionDto> handleProductNotFoundException(ProductNotFoundException ex) {
        ExceptionDto exceptionDto = new ExceptionDto();

        //TODO: Pass the input id in the ExceptionDto.
        exceptionDto.setMessage("Product with id " + ex.getId() + " not found");
        exceptionDto.setSolution("Please check the product id");

        return new ResponseEntity<>(
                exceptionDto,
                HttpStatus.BAD_REQUEST
        );
    }



}
