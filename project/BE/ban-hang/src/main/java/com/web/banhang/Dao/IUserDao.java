package com.web.banhang.Dao;

import com.web.banhang.Entity.User;

import java.util.List;
import java.util.Optional;

public interface IUserDao {
    int count();

    List<User> getList();
   User getUserById(Integer idUser);
    int deleteUser(Integer idUser);
    void insertUser(User user);
    int updateUser(User user);
}
