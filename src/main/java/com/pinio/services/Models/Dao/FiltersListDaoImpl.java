package com.pinio.services.Models.Dao;

import com.pinio.services.Models.Entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@Repository
public class FiltersListDaoImpl implements FiltersListDao{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public SearchBrand obtainBrands(){
        SearchBrand r=new SearchBrand();
        r.setListBrands(new ArrayList<String>());

        String SQL="SELECT\n"+
        "distinct productbrand\n"+
        "FROM productcatalog";

        try {
            Connection con = jdbcTemplate.getDataSource().getConnection();
            PreparedStatement ps = con.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                String p = new String();
                p=(rs.getString("productbrand"));

                r.getListBrands().add(p);
            }
            ps.close();
            rs.close();
            con.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return r;
    }
    public  SearchCategory obtainCategories(){
        SearchCategory r=new SearchCategory();
        r.setCategoryList(new ArrayList<Category>());

        String SQL="SELECT * FROM category";

        try{
            Connection con = jdbcTemplate.getDataSource().getConnection();
            PreparedStatement ps = con.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Category c = new Category();
                c.setIdcategory(rs.getInt("idcategory"));
                c.setName(rs.getString("name"));
                r.getCategoryList().add(c);
            }
            ps.close();
            rs.close();
            con.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return r;
    }
    public  SearchSubcategory obtainSubcategories(Category category){
        SearchSubcategory r=new SearchSubcategory();
        r.setSubcategoryList(new ArrayList<Subcategory>());

        String SQL="SELECT * FROM subcategory as s\n"+
        "WHERE s.idcategory = ? \n";

        try{
            Connection con = jdbcTemplate.getDataSource().getConnection();
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1,category.getIdcategory());

            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Subcategory s = new Subcategory();
                s.setIdsubcategory(rs.getInt("idsubcategory"));
                s.setIdcategory(rs.getInt("idcategory"));
                s.setName(rs.getString("name"));
                r.getSubcategoryList().add(s);
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
