package com.web.banhang.Web.Rest;

import com.web.banhang.Entity.Product;
import com.web.banhang.Service.Dto.ProductDto;
import com.web.banhang.Service.IProductService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductRest {
    IProductService iProductService;

    public ProductRest(IProductService iProductService) {
        this.iProductService = iProductService;
    }

    @GetMapping("")
    public ResponseEntity<List<Product>> getListProducts() {
        HttpHeaders httpHeaders = new HttpHeaders();
        List<Product> productList = iProductService.getListProduct();
        if (productList == null) {
            return new ResponseEntity<List<Product>>(HttpStatus.NOT_FOUND);
        }
        httpHeaders.add("Number Of Records Found", String.valueOf(productList.size()));

        return new ResponseEntity<List<Product>>(productList, httpHeaders, HttpStatus.OK);
    }

    @GetMapping(value = "/getIdProduct/{idProduct}")
    public ResponseEntity<Product> getUserById(@PathVariable("idProduct") Integer idProduct) {
        Product product = iProductService.getIdProduct(idProduct);
        if (product == null) {
            return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(iProductService.getIdProduct(idProduct), HttpStatus.OK);
    }

    @GetMapping(value = "/getListTypeOfProduct/{IDLoaiSanPham}")
    public ResponseEntity<List<ProductDto>> getListTypeOfProduct(@PathVariable("IDLoaiSanPham") Integer IDLoaiSanPham) {
        return new ResponseEntity<>(iProductService.getListTypeOfProduct(IDLoaiSanPham), HttpStatus.OK);
    }

    @DeleteMapping(value = "/deleteProduct/{idProduct}")
    public ResponseEntity<Product> deleteProduct(@PathVariable("idProduct") Integer idProduct) {
        HttpHeaders httpHeaders = new HttpHeaders();
        Product product = iProductService.getIdProduct(idProduct);
        if (product == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        iProductService.deleteProduct(idProduct);
        httpHeaders.add("Product Delete-", String.valueOf(idProduct));
        return new ResponseEntity<Product>(product, httpHeaders, HttpStatus.NO_CONTENT);
    }

    @PostMapping(value = "/insertProduct", produces = "application/json")
    public ResponseEntity<Product> insertProduct(@RequestBody Product product) {
        HttpHeaders httpHeaders = new HttpHeaders();

        iProductService.insertProduct(product);
        httpHeaders.add("Product created -", String.valueOf(product.getNameProduct()));
        return new ResponseEntity<Product>(product, httpHeaders, HttpStatus.CREATED);
    }

    @PutMapping(value = "/updateProduct/{idProduct}")
    public ResponseEntity<Product> updateProduct(@PathVariable("idProduct") Integer idProduct, @RequestBody Product product) {
        HttpHeaders httpHeaders = new HttpHeaders();
        Product isExist = iProductService.getIdProduct(idProduct);
        if (isExist == null) {
            return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
        } else if (product == null) {
            return new ResponseEntity<Product>(HttpStatus.BAD_REQUEST);
        }
        iProductService.updateProduct(product);

        httpHeaders.add("Product update -", String.valueOf(idProduct));
        return new ResponseEntity<Product>(product, httpHeaders, HttpStatus.OK);
    }
}
