package com.web.banhang.Dao;

import com.web.banhang.Entity.User;

import java.util.List;

public interface IUserDao {
    int count();

    List<User> getList();
}
