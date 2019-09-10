package com.web.banhang.Service.Mapper;

import com.web.banhang.Entity.Product;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public  class ProductMapper implements RowMapper<Product>  {
    @Override
    public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Product(
                rs.getInt("IDSanPham"),
                rs.getString("TenSanPham"),
                rs.getString("NguonGoc"),
                rs.getInt("Gia"),
                rs.getString("ChiTietSanPham"),
                rs.getInt("SoLuong"),
                rs.getInt("IDLoaiSanPham"));
    }
}

