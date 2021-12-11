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
    public ProductCatalog addNewProduct(ProductCatalog productcatalog) {
        String SQL = "INSERT into productcatalog \n" +
                "   (idproductcatalog, idsubcategory, productbrand, productmodel, productdescription, \n" +
                "   provider, unitprice, unitsxlot, shippingcost) \n" +
                "values (?, ?, ?, ?, ?, ?, ?, ?, ?); \n";
        try{
            Connection con = jdbcTemplate.getDataSource().getConnection();
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setString(1, productcatalog.getIdProductCatalog());
            ps.setInt(2, productcatalog.getIdsubcategory());
            ps.setString(3, productcatalog.getProductModel());
            ps.setString(4, productcatalog.getProductdescription());
            ps.setString(5, productcatalog.getProvider());
            ps.setFloat(6, productcatalog.getUnitprice());
            ps.setInt(7, productcatalog.getUnitsxlot());
            ps.setFloat(8, productcatalog.getShippingcost());
            ps.executeUpdate();
            ps.close();
            con.commit();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productcatalog;
    }
}
