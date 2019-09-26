package com.web.banhang.Dao.Impl;

import com.web.banhang.Dao.IUserDao;
import com.web.banhang.Entity.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
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
                        new User( rs.getInt("IDNguoiDung"),
                                rs.getString("HoTen"),
                                rs.getString("TaiKhoan"),
                                rs.getString("MatKhau"),
                                rs.getString("DiaChi"),
                                rs.getString("SoDT"),
                                rs.getBoolean("GioiTinh"),
                                rs.getDate("NgaySinh"),
                                rs.getString("Email"),
                                rs.getString("UrlAnhNguoiDung")
                               ));
    }
    @Override
    public User getUserById(Integer id) {
        //Language = SQL
        String query = "SELECT * FROM NguoiDung WHERE IDNguoiDung = ?";
        return jdbc.queryForObject(query,new Object[]{id}, (rs,rowNum)->{
            return convertRsToUser(rs);
        });
    }
    private User convertRsToUser(ResultSet rs) throws SQLException {
        return new User( rs.getInt("IDNguoiDung"),
                        rs.getString("HoTen"),
                        rs.getString("TaiKhoan"),
                        rs.getString("MatKhau"),
                        rs.getString("DiaChi"),
                        rs.getString("SoDT"),
                        rs.getBoolean("GioiTinh"),
                        rs.getDate("NgaySinh"),
                        rs.getString("Email"),
                        rs.getString("UrlAnhNguoiDung"));
    }

    @Override
    public int deleteUser(Integer idUser){
        String query = "delete from NguoiDung where IDNguoiDung= ?";
        return jdbc.update(query, new Object[]{Integer.valueOf(idUser) });
    }

    @Override
    public void insertUser(User user){
        String name = user.getUserName();
        String acc = user.getAccount();
        String pass = user.getPassword();
        String addr = user.getAddress();
        String phone = user.getPhoneNumber();
        boolean gender = user.isGender();
        Date dob = user.getDateOfBirth();
        String email = user.getEmail();
        String url = user.getUrlPhotoUser();
        String query = "INSERT INTO nguoidung (HoTen, TaiKhoan, MatKhau, DiaChi, SoDT, GioiTinh,NgaySinh, Email, UrlAnhNguoiDung) VALUES (?,?,?,?,?,?,?,?,?)";

        jdbc.update(query,name,acc,pass,addr,phone,gender,dob,email,url);

    }
    @Override
    public int updateUser(User user){
        String query = "UPDATE NguoiDung SET HoTen=?, TaiKhoan=?, MatKhau=?,DiaChi=?,SoDT=?, GioiTinh=?,NgaySinh=?,Email=?,UrlAnhNguoiDung=? WHERE IDNguoiDung=?";
        String name = user.getUserName();
        String acc = user.getAccount();
        String pass = user.getPassword();
        String addr = user.getAddress();
        String phone = user.getPhoneNumber();
        boolean gender = user.isGender();
        Date dob = user.getDateOfBirth();
        String email = user.getEmail();
        String url = user.getUrlPhotoUser();
        int id = user.getIdUser();
         return   jdbc.update(query,name,acc,pass,addr,phone,gender,dob,email,url,id);

    }
    @Override
    public User login(String account, String password){
        String query= "SELECT * FROM NguoiDung where TaiKhoan=? AND MatKhau=?";
        return jdbc.queryForObject(query,new Object[]{account,password} ,(rs,rowNum) -> new User(
                rs.getInt("IDNguoiDung"),
                rs.getString("HoTen"),
                rs.getString("TaiKhoan"),
                rs.getString("MatKhau"),
                rs.getString("DiaChi"),
                rs.getString("SoDT"),
                rs.getBoolean("GioiTinh"),
                rs.getDate("NgaySinh"),
                rs.getString("Email"),
                rs.getString("UrlAnhNguoiDung")));
    }

}
