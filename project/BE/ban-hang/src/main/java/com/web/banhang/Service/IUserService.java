package com.web.banhang.Service;

import com.web.banhang.Entity.User;
import com.web.banhang.Service.Dto.UserDto;

import java.util.List;

public interface IUserService {

    Integer totalUser();

    List<UserDto> getList();
    UserDto getUserById(int idUser);
    Integer deleteUser(int idUser);
    void insertUser(User user);
    Integer updateUser(User user);
    UserDto loginUser(String account, String password);
}
