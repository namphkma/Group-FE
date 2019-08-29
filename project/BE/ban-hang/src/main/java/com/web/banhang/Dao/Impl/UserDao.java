package com.web.banhang.Dao.Impl;

import com.web.banhang.Dao.IUserDao;
import com.web.banhang.Entity.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDao implements IUserDao {

    JdbcTemplate jdbc;

    public UserDao(JdbcTemplate jdbc){
        this.jdbc = jdbc;
    }


    @Override
    public int count() {
        return jdbc
                .queryForObject("select count(*) from NguoiDung",Integer.class);
    }

    @Override
    public List<User> getList() {
        return jdbc
                .query("select * from NguoiDung",
                        (rs,rowNum) ->
                        new User(
                            rs.getString("HoTen")
                        ));
    }
}
