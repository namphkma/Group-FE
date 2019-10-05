package com.web.banhang.Web.Controller;

import com.web.banhang.Entity.Product;
import com.web.banhang.Service.IProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/")
public class ProductController {

    IProductService productService;

    public ProductController(IProductService iProductService) {
        this.productService = iProductService;
    }

    @GetMapping
    public String home(Model model){

        model.addAttribute("types",productService.getListProductByListType());
        return "home";
    }

    @GetMapping("/list")
    public String getListProduct(Model model){
        List<Product> products = productService.getListProduct();
        model.addAttribute("products",products);
        return "list-product";
    }

}
