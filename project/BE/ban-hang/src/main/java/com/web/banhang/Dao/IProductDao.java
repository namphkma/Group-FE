package com.web.banhang.Dao;

import com.web.banhang.Entity.Product;
import com.web.banhang.Service.Dto.ProductDto;

import java.util.List;

public interface IProductDao {

    List<Product> getListProduct();

    List<ProductDto> getListTypeOfProduct(Integer idTypyOfProduct);

    Product getIdProduct(Integer idProduct);

    void deleteProduct(Integer idProduct);

    void updateProduct(Product product);

    void insertProduct(Product  product);


}
