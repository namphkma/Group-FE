package com.web.banhang.Service;

import com.web.banhang.Entity.User;

import java.util.List;
import java.util.Optional;

public interface IUserService {

    Integer totalUser();

    List<User> getList();

    User getUserById(int idUser);
    Integer deleteUser(int idUser);
    Integer insertUser(User user);
    Integer updateUser(User user);
}
