package com.web.banhang.Service.Impl;

import com.web.banhang.Dao.IProductDao;
import com.web.banhang.Dao.ITypeProductDao;
import com.web.banhang.Dao.Impl.ProductDao;
import com.web.banhang.Entity.Product;
import com.web.banhang.Entity.TypeProduct;
import com.web.banhang.Service.Dto.ProductDto;
import com.web.banhang.Service.IProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {

    private IProductDao productDao;
    private ITypeProductDao typeProductDao;

    public ProductService(IProductDao productDao, ITypeProductDao typeProductDao) {
        this.productDao = productDao;
        this.typeProductDao = typeProductDao;
    }

    @Override
    public List<Product> getListProduct() {
        return productDao.getListProduct();
    }

    @Override
    public List<ProductDto> getListTypeOfProduct(int idTypeOfProduct) {
        return productDao.getListTypeOfProduct(idTypeOfProduct);
    }

    @Override
    public Product getIdProduct(int idProduct) {
        return productDao.getIdProduct(idProduct);
    }

    @Override
    public void deleteProduct(Integer idProduct) {
        productDao.deleteProduct(idProduct);
    }

    @Override
    public void updateProduct(Product product) {
        productDao.updateProduct(product);
    }

    @Override
    public void insertProduct(Product product) {
        productDao.insertProduct(product);
    }

    @Override
    public List<TypeProduct> getListProductByListType() {
        List<TypeProduct> types = typeProductDao.getListType();
        System.out.println(types.size());
        for (TypeProduct t:types) {
            t.setProducts(productDao.getListTypeOfProduct(t.getId()));
        }

        return types;
    }
}
