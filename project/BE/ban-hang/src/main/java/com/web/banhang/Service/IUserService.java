package com.web.banhang.Service;

import com.web.banhang.Entity.User;

import java.util.List;

public interface IUserService {

    Integer totalUser();

    List<User> getList();
}
