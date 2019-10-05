package com.web.banhang.Entity;

import com.web.banhang.Service.Dto.ProductDto;

import java.util.List;

public class TypeProduct {
    private Integer id;
    private String name;
    private List<ProductDto> products;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ProductDto> getProducts() {
        return products;
    }

    public void setProducts(List<ProductDto> products) {
        this.products = products;
    }

    public TypeProduct(Integer id) {
        this.id = id;
    }

    public TypeProduct(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
}
