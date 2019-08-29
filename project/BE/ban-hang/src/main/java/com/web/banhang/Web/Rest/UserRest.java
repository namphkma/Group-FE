package com.web.banhang.Web.Rest;

import com.web.banhang.Entity.User;
import com.web.banhang.Service.IUserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserRest {

    IUserService userService;

    public UserRest(IUserService userService){
        this.userService = userService;
    }

    @GetMapping(value = "/total")
    public Integer getTotalUser(){
        return userService.totalUser();

    }


    @GetMapping(value = "")
    public List<User> getListUser(){
        return userService.getList();
    }
}

