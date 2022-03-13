package com.company.mupstructspringboot.mapper;

import com.company.mupstructspringboot.dto.ProductDto;
import com.company.mupstructspringboot.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    ProductDto modelToDto(Product product);
    Product dtoToProduct(ProductDto productDto);
    List<ProductDto> modelsToDtos(List<Product> products);
}
