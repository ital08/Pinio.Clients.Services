package com.pinio.services.Models.Dao;

import com.pinio.services.Models.Entity.ProductLot;
import com.pinio.services.Models.Entity.ProductOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Repository
public class ProductLotDaoImpl implements ProductLotDao{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public ProductLot addProductLot(ProductLot productLot) {
        String SQL = "Insert into productslot (idproductslot, idproductinventory, productamount) \n" +
                "values (?,?,?); \n";
        try{
            Connection con = jdbcTemplate.getDataSource().getConnection();
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1, productLot.getIdproductslot());
            ps.setInt(2, productLot.getIdproductsInventory());
            ps.setInt(3, productLot.getProductamount());
            ps.executeUpdate();
            ps.close();
            con.commit();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productLot;
    }
}
