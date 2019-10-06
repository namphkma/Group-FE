package com.web.banhang.Entity;

public class Product {
    private int idProduct;
    private String nameProduct;
    private String origin;
    private int price;
    private String details;
    private int quantity;
    private int idTypeOfProduct;
    private Image image;

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public Product() {
    }

    public Product(int idProduct, String nameProduct, String origin, int price, String details, int quantity, int idTypeOfProduct) {
        this.idProduct = idProduct;
        this.nameProduct = nameProduct;
        this.origin = origin;
        this.price = price;
        this.details = details;
        this.quantity = quantity;
        this.idTypeOfProduct = idTypeOfProduct;
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

    public int getIdTypeOfProduct() {
        return idTypeOfProduct;
    }

    public void setIdTypeOfProduct(int idTypeOfProduct) {
        this.idTypeOfProduct = idTypeOfProduct;
    }
}
