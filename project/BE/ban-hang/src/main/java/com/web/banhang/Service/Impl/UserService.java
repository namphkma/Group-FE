package com.web.banhang.Service.Impl;


import com.web.banhang.Dao.IUserDao;
import com.web.banhang.Entity.User;
import com.web.banhang.Service.Dto.UserDto;
import com.web.banhang.Service.IUserService;
import com.web.banhang.Service.Mapper.UserMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {

    private IUserDao userDao;
    private UserMapper userMapper;
    public UserService(IUserDao userDao, UserMapper userMapper){
        this.userMapper = userMapper;
        this.userDao = userDao;
    }

    @Override
    public Integer totalUser() {
        return userDao.count();
    }

    @Override
    public List<UserDto> getList() {
        return userMapper.mapToDto(userDao.getList());
    }

    @Override
    public UserDto getUserById(int idUser){
        return userMapper.mapToDto(userDao.getUserById(idUser));
    }
    @Override
    public Integer deleteUser(int idUser){
        return userDao.deleteUser(idUser);
    }

    @Override
    public void insertUser(User user){
       userDao.insertUser(user);
    }

    @Override
    public Integer updateUser(User user){
         return userDao.updateUser(user);
    }
}
