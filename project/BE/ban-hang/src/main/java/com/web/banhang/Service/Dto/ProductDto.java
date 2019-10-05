package com.web.banhang.Service.Dto;

public class ProductDto {
    private int idProduct;
    private String nameProduct;
    private String origin;
    private int price;
    private String details;
    private int quantity;
    private String typeName;

    public ProductDto(int idProduct, String nameProduct, String origin, int price, String details, int quantity, String typeName) {
        this.idProduct = idProduct;
        this.nameProduct = nameProduct;
        this.origin = origin;
        this.price = price;
        this.details = details;
        this.quantity = quantity;
        this.typeName = typeName;
    }

    public ProductDto() {
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
}
