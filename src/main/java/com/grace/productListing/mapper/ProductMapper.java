package com.grace.productListing.mapper;


import com.grace.productListing.dto.ProductDTO;
import com.grace.productListing.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    Product mapProductDTOToProduct(ProductDTO restaurantDTO);

    ProductDTO mapProductToProductDTO(Product product);

}
