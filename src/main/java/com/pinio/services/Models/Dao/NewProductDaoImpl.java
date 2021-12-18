package com.pinio.services.Models.Dao;

import com.pinio.services.Models.Entity.ProductCatalog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.*;
@Repository
public class NewProductDaoImpl implements NewProductDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    private Integer crearIdImg(){
        String SQL = "select coalesce(max(idimagescatalog)+1,1) codigo from imagescatalog";
        Integer codigo= 0;
        try{
            Connection con = jdbcTemplate.getDataSource().getConnection();
            Statement ps = con.createStatement();
            ResultSet rs = ps.executeQuery(SQL);
            while(rs.next()){
                codigo = rs.getInt("codigo");
            }
            rs.close();
            ps.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return codigo;
    }
    public ProductCatalog addNewProduct(ProductCatalog productcatalog) {

        String SQL1 = "INSERT into productcatalog \n" +
                "   (idproductcatalog, idsubcategory, productbrand, productmodel, productdescription, \n" +
                "   provider, unitprice, unitsxlot, shippingcost) \n" +
                "values (?, ?, ?, ?, ?, ?, ?, ?, ?); \n";
        try{
            Connection con = jdbcTemplate.getDataSource().getConnection();
            PreparedStatement ps = con.prepareStatement(SQL1);
            ps.setString(1, productcatalog.getIdProductCatalog());
            ps.setInt(2, productcatalog.getIdsubcategory());
            ps.setString(3, productcatalog.getProductBrand());
            ps.setString(4, productcatalog.getProductModel());
            ps.setString(5, productcatalog.getProductdescription());
            ps.setString(6, productcatalog.getProvider());
            ps.setFloat(7, productcatalog.getUnitprice());
            ps.setInt(8, productcatalog.getUnitsxlot());
            ps.setFloat(9, productcatalog.getShippingcost());
            ps.executeUpdate();
            ps.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String SQL2 = "INSERT into imagescatalog \n" +
                "   (idproductcatalog, idimagescatalog, urlimage, position) \n" +
                "values (?, ?, ?, 2); \n" ;
        Integer idimg = crearIdImg();
        try{
            Connection con = jdbcTemplate.getDataSource().getConnection();
            PreparedStatement ps = con.prepareStatement(SQL2);
            ps.setString(1, productcatalog.getIdProductCatalog());
            ps.setInt(2, idimg);
            ps.setString(3, productcatalog.getUrlimage());
            ps.executeUpdate();
            ps.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productcatalog;
    }
}
