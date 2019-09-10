package com.web.banhang.Web.Rest;

import com.web.banhang.Entity.Product;
import com.web.banhang.Service.IProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductRest {
        IProductService iProductService;

    public ProductRest(IProductService iProductService) {
        this.iProductService = iProductService;
    }

    @GetMapping("")
    public List<Product> getListProducts(){
        return iProductService.getListProduct();
    }

}
