package com.web.banhang.Service.Impl;

import com.web.banhang.Dao.IProduct;
import com.web.banhang.Dao.Impl.ProductDao;
import com.web.banhang.Entity.Product;
import com.web.banhang.Service.IProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {

    ProductDao productDao ;

    public ProductService(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    public List<Product> getListProduct() {
        return productDao.getListProduct();
    }

    @Override
    public List<Product> getListTypeOfProduct(int idTypeOfProduct) {
        return productDao.getListTypeOfProduct(idTypeOfProduct);
    }

    @Override
    public Product getIdProduct(int idProduct) {
        return productDao.getIdProduct(idProduct);
    }
}
