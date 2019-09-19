package com.web.banhang.Service.Impl;

import com.web.banhang.Dao.IUserDao;
import com.web.banhang.Entity.User;
import com.web.banhang.Service.IUserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {

    private IUserDao userDao;

    public UserService(IUserDao userDao){
        this.userDao = userDao;
    }

    @Override
    public Integer totalUser() {
        return userDao.count();
    }

    @Override
    public List<User> getList() {
        return userDao.getList();
    }

    @Override
    public User getUserById(int idUser){
        return userDao.getUserById(idUser);
    }
    @Override
    public Integer deleteUser(int idUser){
        return userDao.deleteUser(idUser);
    }

    @Override
    public Integer insertUser(User user){
        return userDao.insertUser(user);
    }

    @Override
    public Integer updateUser(User user){
         return userDao.updateUser(user);
    }
}
