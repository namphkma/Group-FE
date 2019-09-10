package com.web.banhang.Web.Rest;

import com.web.banhang.Entity.User;
import com.web.banhang.Service.Dto.UserDto;
import com.web.banhang.Service.IUserService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

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
    public List<UserDto> getListUser(){
        return userService.getList();
    }

    @GetMapping(value = "/{idUser}")
    public ResponseEntity<UserDto> getUserById(@PathVariable("idUser") Integer idUser){
        UserDto userExist = userService.getUserById(idUser);
        if(userExist == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(userExist, HttpStatus.ACCEPTED);
    }

    @DeleteMapping(value = "/deleteUser/{idUser}")
    public ResponseEntity<Integer> deleteUser(@PathVariable("idUser")Integer idUser){
        UserDto u = userService.getUserById(idUser);
        if(u==null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(userService.deleteUser(idUser),HttpStatus.ACCEPTED);
    }

    @PutMapping (value = "/updateUser/{idUser}")
    public ResponseEntity<Integer> updateUser(@PathVariable("idUser") Integer idUser, @RequestBody User user){
         UserDto userExist = userService.getUserById(idUser);
        if(userExist == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else if(user == null){
            return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(userService.updateUser(user),HttpStatus.OK);
    }

    @PostMapping(value = "/insertUser", produces = "application/json")
    public ResponseEntity<User> insertUser(@RequestBody User user, UriComponentsBuilder builder){
        if(user == null){
            return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        userService.insertUser(user);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/insertUser/{idUser}").buildAndExpand(user.getIdUser()).toUri());
        return new ResponseEntity<>(user,HttpStatus.CREATED);
    }

}

