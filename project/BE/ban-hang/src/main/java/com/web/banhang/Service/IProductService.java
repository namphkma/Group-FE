package com.web.banhang.Service;

import com.web.banhang.Entity.Product;

import java.util.List;

public interface IProductService {
    List<Product> getListProduct();
    List<Product> getListTypeOfProduct(int idTypeOfProduct);
    Product getIdProduct(int idProduct);
}
