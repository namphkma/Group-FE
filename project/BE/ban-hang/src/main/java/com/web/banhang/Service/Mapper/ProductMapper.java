package com.web.banhang.Service.Mapper;

import com.web.banhang.Entity.Product;
import com.web.banhang.Service.Dto.ProductDto;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductMapper {
    public ProductDto mapToDto(Product entity) {
        ProductDto productDto = new ProductDto();
        productDto.setImage(entity.getImage());
        productDto.setDetails(entity.getDetails());
        productDto.setIdProduct(entity.getIdProduct());
        productDto.setOrigin(entity.getOrigin());
        productDto.setNameProduct(entity.getNameProduct());
        productDto.setPrice(entity.getPrice());
        productDto.setQuantity(entity.getQuantity());
        productDto.setTypeName(entity.getType().getName());
        return productDto;
    }

    public List<ProductDto> mapToDto(List<Product> list) {
        return list.stream().map(e -> mapToDto(e)).collect(Collectors.toList());
    }
}

