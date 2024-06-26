package com.grace.productListing.controller;

import com.grace.productListing.dto.ProductDTO;
import com.grace.productListing.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@CrossOrigin
public class ProductController {

    @Autowired
    ProductService productService;


    @GetMapping("/fetchAllProducts")
    public ResponseEntity<List<ProductDTO>> fetchAllProducts(){
        List<ProductDTO> allProducts = productService.findAllProducts();
        return new ResponseEntity<>(allProducts, HttpStatus.OK);
    }

    @PostMapping("/addProduct")
    public ResponseEntity<ProductDTO> saveProduct(@RequestBody ProductDTO productDTO) {
        ProductDTO productAdded = productService.addProductInDB(productDTO);
        return new ResponseEntity<>(productAdded, HttpStatus.CREATED);
    }

    @GetMapping("fetchById/{id}")
    public ResponseEntity<ProductDTO> findProductById(@PathVariable Integer id) {
        return productService.fetchProductById(id);
    }

}

