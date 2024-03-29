package com.web.banhang.Entity;

public class Image {
    private Integer id;
    private String url;
    private Product product;

    public Image(Integer id, String url) {
        this.id = id;
        this.url = url;
    }

    public Image(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
