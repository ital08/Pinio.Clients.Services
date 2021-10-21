package com.pinio.services.Models.Dao;

import com.pinio.services.Models.Entity.ProductCatalog;
import com.pinio.services.Models.Entity.SearchProductCatalog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
@Repository
public class ProductCatalogDaoImpl implements ProductCatalogDao{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public SearchProductCatalog getProductCatalog (ProductCatalog productcatalog){
        SearchProductCatalog r = new SearchProductCatalog();
        r.setListProductCatalog(new ArrayList<ProductCatalog>());
        String SQL = "SELECT\n" +
                "p.idproductcatalog AS idproductcatalog,\n" +
                "p.productbrand AS productbrand,\n" +
                "p.productmodel AS productmodel,\n" +
                "p.unitprice AS unitprice,\n" +
                "u.urlimage AS urlimage\n" +
                "FROM productcatalog as p\n" +
                "INNER JOIN imagescatalog as u on u.idproductcatalog = p.idproductcatalog\n" +
                "WHERE upper(productmodel) like ? ;";
        try {
            Connection con = jdbcTemplate.getDataSource().getConnection();
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setString(1,productcatalog.getProductModel().toUpperCase()+"%");

            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                ProductCatalog p = new ProductCatalog();
                p.setIdProductCatalog(rs.getString("idproductcatalog"));
                p.setProductBrand(rs.getString("productbrand"));
                p.setProductModel(rs.getString("productmodel"));
                p.setUnitprice(rs.getFloat("unitprice"));
                p.setUrlimage(rs.getString("urlimage"));
                r.getListProductCatalog().add(p);
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
