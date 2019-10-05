package com.web.banhang.Dao.Impl;

import com.web.banhang.Dao.ITypeProductDao;
import com.web.banhang.Entity.Product;
import com.web.banhang.Entity.TypeProduct;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Repository
public class TypeProductDao implements ITypeProductDao {
    JdbcTemplate jdbc;

    public TypeProductDao(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    @Override
    public List<TypeProduct> getListType() {
        String query = "select * from  loaisanpham";
        return jdbc.query(query,
                (rs, rowNum) ->
                        new TypeProduct(
                                rs.getInt("IDLoaiSanPham"),
                                rs.getString("TenLoaiSanPham")
                        ));
    }
}
