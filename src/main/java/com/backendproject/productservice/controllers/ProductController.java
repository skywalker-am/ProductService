package com.backendproject.productservice.controllers;

import com.backendproject.productservice.exceptions.ProductNotFoundException;
import com.backendproject.productservice.models.Product;
import com.backendproject.productservice.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") Long id) throws ProductNotFoundException {

         //   throw new RuntimeException("Something went wrong");
 //        ResponseEntity<Product> responseEntity = null;

//        try {
//            responseEntity = new ResponseEntity<>(
//                    productService.getSingleProduct(id),
//                    HttpStatus.OK
//            );
//        } catch (RuntimeException e) {
//            responseEntity = new ResponseEntity<>(
//                    HttpStatus.BAD_REQUEST
//            );
//        }

        ResponseEntity<Product> responseEntity = new ResponseEntity<>(
                productService.getSingleProduct(id),
                HttpStatus.OK
        );

        return responseEntity;
    }

    @GetMapping()
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    //Delete request
    public void deleteProduct(Long productId) {
    }

    //patch request -> http://localhost:8080/products/1
    @PatchMapping("/{id}")
    public Product updateProduct(@PathVariable("id") Long id, @RequestBody Product product) {
        return productService.updateProduct(id, product);
    }

    @PutMapping("/{id}")
    public Product replaceProduct(@PathVariable("id") Long id, @RequestBody Product product) {
        return null;
    }

//    @ExceptionHandler(ArithmeticException.class)
//    public ResponseEntity<String> handleArithmeticException() {
//        ResponseEntity<String> response = new ResponseEntity<>(
//                "ArithmeticException has happened, Inside the controller",
//                HttpStatus.BAD_REQUEST
//        );
//
//        return response;
//    }



}
