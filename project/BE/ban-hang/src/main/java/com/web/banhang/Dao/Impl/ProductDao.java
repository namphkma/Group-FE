package com.web.banhang.Dao.Impl;

import com.web.banhang.Dao.IProductDao;
import com.web.banhang.Entity.Image;
import com.web.banhang.Entity.Product;
import com.web.banhang.Service.Dto.ProductDto;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ProductDao implements IProductDao {
    JdbcTemplate jdbc;

    @Override
    public void deleteProduct(Integer idProduct) {
        String sql = "Delete from sanpham where IDSanPham =?";
        jdbc.update(sql,idProduct);
    }

    @Override
    public void updateProduct(Product product) {
    String query = "Update Sanpham set TenSanPham =?,NguonGoc =?,Gia=? ,ChiTietSanPham=?,SoLuong=?,IDLoaiSanPham=? where IDSanPham=?";
    jdbc.update(query, product.getNameProduct(), product.getOrigin(),product.getPrice(),product.getDetails(), product.getQuantity(), product.getIdTypeOfProduct(), product.getIdProduct());
    }

    @Override
    public void insertProduct(Product product) {
        String  quyery="INSERT INTO sanpham(TenSanPham,NguonGoc,Gia,ChiTietSanPham,SoLuong,IDLoaiSanPham) VALUES(?,?,?,?,?,?) ";
        jdbc.update(quyery,product.getNameProduct(), product.getOrigin(),product.getPrice(),product.getDetails(), product.getQuantity(), product.getIdTypeOfProduct());

    }



    public ProductDao(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    @Override
    public List<Product> getListProduct() {
        String query = "SELECT sanpham.*, anh.IDAnh, anh.UrlAnh FROM  sanpham JOIN anh ON sanpham.IDSanPham = anh.IDSanPham";
        return jdbc.query(query,
                (rs, rowNum) -> {
                    Product p = convertRsToProduct(rs);
                    Image i = new Image(rs.getInt("IDAnh"),rs.getString("UrlAnh"));
                    p.setImage(i);
                    return  p;
                });
    }

    @Override
    public List<ProductDto> getListTypeOfProduct(Integer idTypyOfProduct) {
        String query = "SELECT sanpham.*, anh.IDAnh, anh.UrlAnh, loaisanpham.TenLoaiSanPham " +
                " FROM sanpham INNER JOIN loaisanpham" +
                " ON sanpham.IDLoaiSanPham = loaisanpham.IDLoaiSanPham" +
                " JOIN anh ON sanpham.IDSanPham = anh.IDSanPham" +
                " WHERE sanpham.IDLoaiSanPham = ?";
        return  jdbc.query(query,new Object[]{idTypyOfProduct},
                (rs, rowNum) ->{
                    ProductDto product = new ProductDto(
                            rs.getInt("IDSanPham"),
                            rs.getString("TenSanPham"),
                            rs.getString("NguonGoc"),
                            rs.getInt("Gia"),
                            rs.getString("ChiTietSanPham"),
                            rs.getInt("SoLuong"),
                            rs.getString("TenLoaiSanPham")
                    );
                    Image i = new Image(rs.getInt("IDAnh"),rs.getString("UrlAnh"));
                    product.setImage(i);
                    return product;
                });
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
            String query ="Select * from sanpham where IDSanPham=?";
            return  jdbc.queryForObject(query,new Object[]{idProduct}, (rs,rowNum)->{
                return convertRsToProduct(rs);
            });
    }

}
