package com.pinio.services.Models.Dao;

import com.pinio.services.Models.Entity.ProductOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Repository
public class ProductOrderDaoImpl implements ProductOrderDao{
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public ProductOrder addProductOrder(ProductOrder productorder) {
        String SQL = "Insert into productorder\n" +
                " (idproductorder, idproductcatalog, idemployee, totalcost, nameEmpresa, rucEmpresa, cantLot)\n" +
                "values (?,?,?,?,?,?,?);\n";
        try{
            Connection con = jdbcTemplate.getDataSource().getConnection();
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1, productorder.getIdproductorder());
            ps.setString(2, productorder.getIdproductcatalog());
            ps.setInt(3, productorder.getIdemployee());
            ps.setFloat(4, productorder.getTotalcost());
            ps.setString(5, productorder.getNameempresa());
            ps.setString(6, productorder.getRucempresa());
            ps.setInt(7, productorder.getCantlot());
            ps.executeUpdate();
            ps.close();
            con.commit();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productorder;
    }
}
