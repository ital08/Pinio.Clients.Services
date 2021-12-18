package com.pinio.services.Models.Dao;

import com.pinio.services.Models.Entity.ProductCatalog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class ShowProductDaoImpl implements ShowProductDao{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public ProductCatalog showProduct(ProductCatalog productCatalog){
        ProductCatalog r = new ProductCatalog();

        String SQL="SELECT\n"+
                "p.productbrand,\n"+
                "p.idproductcatalog,\n"+
                "p.productmodel,\n"+
                "p.productdescription,\n"+
                "p.unitprice,\n"+
                "i.urlimage\n"+
                "FROM productcatalog as p\n"+
                "INNER JOIN imagescatalog as i on i.idproductcatalog=p.idproductcatalog\n"+
                "WHERE p.idproductcatalog= ?";
        try {
            Connection con = jdbcTemplate.getDataSource().getConnection();
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setString(1,productCatalog.getIdProductCatalog());

            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                r.setIdProductCatalog(rs.getString("idproductcatalog"));
                r.setProductBrand(rs.getString("productbrand"));
                r.setProductModel(rs.getString("productmodel"));
                r.setUnitprice(rs.getFloat("unitprice"));
                r.setUrlimage(rs.getString("urlimage"));
                r.setProductdescription(rs.getString("productdescription"));
            }
            ps.close();
            rs.close();
            con.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return r;

    }
}
