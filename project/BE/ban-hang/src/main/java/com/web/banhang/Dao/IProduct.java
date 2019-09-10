package com.web.banhang.Dao;

import com.web.banhang.Entity.Product;

import java.util.List;

public interface IProduct {
    List<Product> getListProduct();
    List<Product> getListTypeOfProduct(Integer idTypyOfProduct);
    Product getIdProduct(Integer idProduct);

}
