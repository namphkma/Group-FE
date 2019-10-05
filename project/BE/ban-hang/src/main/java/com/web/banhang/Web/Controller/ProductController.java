package com.web.banhang.Web.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class ProductController {

    @GetMapping
    public String home(){
        return "home";
    }

    @GetMapping("/list")
    public String getListProduct(){
        return "list-product";
    }
}
