package com.web.banhang.Web.Rest;

import com.web.banhang.Entity.User;
import com.web.banhang.Service.IUserService;
import com.web.banhang.Service.Impl.UserService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

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
    @GetMapping(value = "/{idUser}")
    public ResponseEntity<User> getUserById(@PathVariable("idUser") Integer idUser){
        User userExist = userService.getUserById(idUser);
        if(userExist == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(userExist, HttpStatus.ACCEPTED);
    }
    @DeleteMapping(value = "/deleteUser/{idUser}")
    public ResponseEntity<Integer> deleteUser(@PathVariable("idUser")Integer idUser){
        User u = userService.getUserById(idUser);
        if(u==null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(userService.deleteUser(idUser),HttpStatus.ACCEPTED);
    }

    @PutMapping (value = "/updateUser/{idUser}")
    public ResponseEntity<Integer> updateUser(@PathVariable("idUser") Integer idUser, @RequestBody User user){
         User userExist = userService.getUserById(idUser);
        if(userExist == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else if(user == null){
            return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(userService.updateUser(user),HttpStatus.OK);
    }

    @PostMapping(value = "/insertUser")
    public ResponseEntity<User> insertUser(@RequestBody User user, UriComponentsBuilder builder){
        userService.insertUser(user);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/insertUser/{idUser}").buildAndExpand(user.getIdUser()).toUri());
        return new ResponseEntity<>(user,HttpStatus.CREATED);
    }

}

