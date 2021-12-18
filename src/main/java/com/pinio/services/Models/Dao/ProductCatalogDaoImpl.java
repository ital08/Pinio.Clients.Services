package com.pinio.services.Models.Dao;

import com.pinio.services.Models.Entity.ProductCatalog;
import com.pinio.services.Models.Entity.SearchProductCatalog;
import com.pinio.services.Models.Entity.Subcategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
@Repository
public class ProductCatalogDaoImpl implements ProductCatalogDao{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public SearchProductCatalog getProductCatalog (ProductCatalog productCatalog,String orden,Integer pagNum,Integer pagSize){
        SearchProductCatalog r = new SearchProductCatalog();
        r.setListProductCatalog(new ArrayList<ProductCatalog>());

        String SQL = "SELECT\n" +
                "p.idproductcatalog,\n"+
                "p.productbrand,\n" +
                "p.productmodel,\n" +
                "p.unitprice,\n" +
                "i.urlimage\n" +
                "FROM productcatalog as p\n" +
                "INNER JOIN imagescatalog as i on i.idproductcatalog=p.idproductcatalog\n" +
                "WHERE upper(p.productmodel) like ?\n"+
                "ORDER BY productmodel asc \n"+
                "limit ? offset ((?-1)*?)";
        if(orden.toUpperCase().equals("DESC")){
            SQL = "SELECT\n" +
                    "p.idproductcatalog,\n"+
                    "p.productbrand,\n" +
                    "p.productmodel,\n" +
                    "p.unitprice,\n" +
                    "i.urlimage\n" +
                    "FROM productcatalog as p\n" +
                    "INNER JOIN imagescatalog as i on i.idproductcatalog=p.idproductcatalog\n" +
                    "WHERE upper(p.productmodel) like ?\n"+
                    "ORDER BY unitprice desc \n"+
                    "limit ? offset ((?-1)*?)";
        }
        if(orden.toUpperCase().equals("ASC")){
            SQL = "SELECT\n" +
                    "p.idproductcatalog,\n"+
                    "p.productbrand,\n" +
                    "p.productmodel,\n" +
                    "p.unitprice,\n" +
                    "i.urlimage\n" +
                    "FROM productcatalog as p\n" +
                    "INNER JOIN imagescatalog as i on i.idproductcatalog=p.idproductcatalog\n" +
                    "WHERE upper(p.productmodel) like ?\n"+
                    "ORDER BY unitprice asc\n"+
                    "limit ? offset ((?-1)*?)";
        }
        try {
            Connection con = jdbcTemplate.getDataSource().getConnection();
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(3,pagNum);
            ps.setInt(2,pagSize);
            ps.setInt(4,pagSize);
            ps.setString(1,"%"+productCatalog.getProductModel().toUpperCase()+"%");

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

    public SearchProductCatalog getProductCatalogSub (Subcategory subcategory, String orden, Integer pagNum, Integer pagSize){
        SearchProductCatalog r = new SearchProductCatalog();
        r.setListProductCatalog(new ArrayList<ProductCatalog>());

        String SQL = "SELECT\n" +
                "p.idproductcatalog,\n"+
                "p.productbrand,\n" +
                "p.productmodel,\n" +
                "p.unitprice,\n" +
                "i.urlimage\n" +
                "FROM productcatalog as p\n" +
                "INNER JOIN imagescatalog as i on i.idproductcatalog=p.idproductcatalog\n" +
                "WHERE p.idsubcategory=  ?\n"+
                "ORDER BY productmodel asc \n"+
                "limit ? offset ((?-1)*?)";
        if(orden.toUpperCase().equals("DESC")){
            SQL = "SELECT\n" +
                    "p.idproductcatalog,\n"+
                    "p.productbrand,\n" +
                    "p.productmodel,\n" +
                    "p.unitprice,\n" +
                    "i.urlimage\n" +
                    "FROM productcatalog as p\n" +
                    "INNER JOIN imagescatalog as i on i.idproductcatalog=p.idproductcatalog\n" +
                    "WHERE p.idsubcategory= ?\n"+
                    "ORDER BY unitprice desc \n"+
                    "limit ? offset ((?-1)*?)";
        }
        if(orden.toUpperCase().equals("ASC")){
            SQL = "SELECT\n" +
                    "p.idproductcatalog,\n"+
                    "p.productbrand,\n" +
                    "p.productmodel,\n" +
                    "p.unitprice,\n" +
                    "i.urlimage\n" +
                    "FROM productcatalog as p\n" +
                    "INNER JOIN imagescatalog as i on i.idproductcatalog=p.idproductcatalog\n" +
                    "WHERE p.idsubcategory= ?\n"+
                    "ORDER BY unitprice asc\n"+
                    "limit ? offset ((?-1)*?)";
        }
        try {
            Connection con = jdbcTemplate.getDataSource().getConnection();
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(3,pagNum);
            ps.setInt(2,pagSize);
            ps.setInt(4,pagSize);
            ps.setInt(1,subcategory.getIdsubcategory());


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

    public SearchProductCatalog getProductCatalogPrice (String orden, Integer pagNum, Integer pagSize,Integer min,Integer max){
        SearchProductCatalog r = new SearchProductCatalog();
        r.setListProductCatalog(new ArrayList<ProductCatalog>());

        String SQL = "SELECT\n" +
                "p.idproductcatalog,\n"+
                "p.productbrand,\n" +
                "p.productmodel,\n" +
                "p.unitprice,\n" +
                "i.urlimage\n" +
                "FROM productcatalog as p\n" +
                "INNER JOIN imagescatalog as i on i.idproductcatalog=p.idproductcatalog\n" +
                "WHERE p.unitprice between ? and ? \n"+
                "ORDER BY productmodel asc \n"+
                "limit ? offset ((?-1)*?)";
        if(orden.toUpperCase().equals("DESC")){
            SQL = "SELECT\n" +
                    "p.idproductcatalog,\n"+
                    "p.productbrand,\n" +
                    "p.productmodel,\n" +
                    "p.unitprice,\n" +
                    "i.urlimage\n" +
                    "FROM productcatalog as p\n" +
                    "INNER JOIN imagescatalog as i on i.idproductcatalog=p.idproductcatalog\n" +
                    "WHERE p.unitprice between ? and ? \n"+
                    "ORDER BY unitprice desc \n"+
                    "LIMIT ? offset ((?-1)*?)";
        }
        if(orden.toUpperCase().equals("ASC")){
            SQL = "SELECT\n" +
                    "p.idproductcatalog,\n"+
                    "p.productbrand,\n" +
                    "p.productmodel,\n" +
                    "p.unitprice,\n" +
                    "i.urlimage\n" +
                    "FROM productcatalog as p\n" +
                    "INNER JOIN imagescatalog as i on i.idproductcatalog=p.idproductcatalog\n" +
                    "WHERE p.unitprice between ? and ? \n"+
                    "ORDER BY unitprice asc\n"+
                    "limit ? offset ((?-1)*?)";
        }
        try {
            Connection con = jdbcTemplate.getDataSource().getConnection();
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(4,pagNum);
            ps.setInt(3,pagSize);
            ps.setInt(5,pagSize);
            ps.setInt(1,min);
            ps.setInt(2,max);

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

    public SearchProductCatalog getProductCatalogBrand (ProductCatalog productCatalog, String orden, Integer pagNum, Integer pagSize){
        SearchProductCatalog r = new SearchProductCatalog();
        r.setListProductCatalog(new ArrayList<ProductCatalog>());

        String SQL = "SELECT\n" +
                "p.idproductcatalog,\n"+
                "p.productbrand,\n" +
                "p.productmodel,\n" +
                "p.unitprice,\n" +
                "i.urlimage\n" +
                "FROM productcatalog as p\n" +
                "INNER JOIN imagescatalog as i on i.idproductcatalog=p.idproductcatalog\n" +
                "WHERE p.productbrand = ? \n"+
                "ORDER BY productmodel asc \n"+
                "limit ? offset ((?-1)*?)";
        if(orden.toUpperCase().equals("DESC")){
            SQL = "SELECT\n" +
                    "p.idproductcatalog,\n"+
                    "p.productbrand,\n" +
                    "p.productmodel,\n" +
                    "p.unitprice,\n" +
                    "i.urlimage\n" +
                    "FROM productcatalog as p\n" +
                    "INNER JOIN imagescatalog as i on i.idproductcatalog=p.idproductcatalog\n" +
                    "WHERE p.productbrand = ? \n"+
                    "ORDER BY unitprice desc \n"+
                    "limit ? offset ((?-1)*?)";
        }
        if(orden.toUpperCase().equals("ASC")){
            SQL = "SELECT\n" +
                    "p.idproductcatalog,\n"+
                    "p.productbrand,\n" +
                    "p.productmodel,\n" +
                    "p.unitprice,\n" +
                    "i.urlimage\n" +
                    "FROM productcatalog as p\n" +
                    "INNER JOIN imagescatalog as i on i.idproductcatalog=p.idproductcatalog\n" +
                    "WHERE p.productbrand = ? \n"+
                    "ORDER BY unitprice asc\n"+
                    "limit ? offset ((?-1)*?)";
        }
        try {
            Connection con = jdbcTemplate.getDataSource().getConnection();
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(3,pagNum);
            ps.setInt(2,pagSize);
            ps.setInt(4,pagSize);
            ps.setString(1,productCatalog.getProductBrand());

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
