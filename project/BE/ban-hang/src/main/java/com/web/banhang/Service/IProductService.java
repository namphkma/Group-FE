package com.web.banhang.Service;

import com.web.banhang.Entity.Product;
import com.web.banhang.Entity.TypeProduct;
import com.web.banhang.Service.Dto.ProductDto;

import java.util.List;

public interface IProductService {
    List<Product> getListProduct();

    List<ProductDto> getListTypeOfProduct(int idTypeOfProduct);

    Product getIdProduct(int idProduct);

    void deleteProduct(Integer idProduct);

    void updateProduct(Product product);

    void insertProduct(Product  product);

    List<TypeProduct> getListProductByListType();
}
