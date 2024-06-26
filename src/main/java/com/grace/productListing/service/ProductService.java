package com.grace.productListing.service;


import com.grace.productListing.dto.ProductDTO;
import com.grace.productListing.entity.Product;
import com.grace.productListing.mapper.ProductMapper;
import com.grace.productListing.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    ProductRepo productRepo;


    public List<ProductDTO> findAllProducts() {
        List<Product> products = productRepo.findAll();
        List<ProductDTO> productDTOList = products.stream().map(product -> ProductMapper.INSTANCE.mapProductToProductDTO(product)).collect(Collectors.toList());
        return productDTOList;
    }

    public ProductDTO addProductInDB(ProductDTO productDTO) {
        Product saveProduct =  productRepo.save(ProductMapper.INSTANCE.mapProductDTOToProduct(productDTO));
        return ProductMapper.INSTANCE.mapProductToProductDTO(saveProduct);
    }

    public ResponseEntity<ProductDTO> fetchProductById(Integer id) {
        Optional<Product> product =  productRepo.findById(id);
        if(product.isPresent()){
            return new ResponseEntity<>(ProductMapper.INSTANCE.mapProductToProductDTO(product.get()), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
}