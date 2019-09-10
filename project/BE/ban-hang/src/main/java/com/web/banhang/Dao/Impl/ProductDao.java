package com.web.banhang.Dao.Impl;

import com.web.banhang.Dao.IProduct;
import com.web.banhang.Entity.Product;
import com.web.banhang.Service.Mapper.ProductMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ProductDao implements IProduct {
    JdbcTemplate jdbc;

    public ProductDao(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    @Override
    public List<Product> getListProduct() {

        String query = "select * from  sanpham";
        return jdbc.query(query,
                (rs, rowNum) ->
                        new Product(
                                rs.getInt("IDSanPham"),
                                rs.getString("TenSanPham"),
                                rs.getString("NguonGoc"),
                                rs.getInt("Gia"),
                                rs.getString("ChiTietSanPham"),
                                rs.getInt("SoLuong"),
                                rs.getInt("IDLoaiSanPham")

                        ));
    }

    @Override
    public List<Product> getListTypeOfProduct(Integer idTypyOfProduct) {
        String query = "SELECT * FROM sanpham WHERE IDLoaiSanPham = ?";
        return null;


    }

    private Product convertRsToProduct(ResultSet rs)  throws SQLException  {
        return     new Product(
                    rs.getInt("IDSanPham"),
                    rs.getString("TenSanPham"),
                    rs.getString("NguonGoc"),
                    rs.getInt("Gia"),
                    rs.getString("ChiTietSanPham"),
                    rs.getInt("SoLuong"),
                    rs.getInt("IDLoaiSanPham"));
    }


    @Override
        public Product getIdProduct(Integer idProduct) {
            String query ="Select from SanPham where IDSanPham=:"+idProduct;
            return  jdbc.queryForObject(query,new Object[]{idProduct}, (rs,rowNum)->{
                return convertRsToProduct(rs);
            });
    }


}
