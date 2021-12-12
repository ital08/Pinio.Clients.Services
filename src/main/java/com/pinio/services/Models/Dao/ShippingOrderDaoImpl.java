package com.pinio.services.Models.Dao;

import com.pinio.services.Models.Entity.ProductCatalog;
import com.pinio.services.Models.Entity.SearchProductCatalog;
import com.pinio.services.Models.Entity.ShippingDtaEmp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@Repository
public class ShippingOrderDaoImpl implements ShippingOrderDao{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public ShippingDtaEmp getShippingOrders(ShippingDtaEmp shippingDtaEmp) {
        ShippingDtaEmp r = new ShippingDtaEmp();
        String SQL = "Select idshippingorder,namedepartment, nameprovincia, namedistrict,nombreEmpleado \n" +
                "from shippingDtaEmp \n" +
                "where idshippingstate = 2 \n" +
                "and idshippingorder = ?; \n";
        try {
            Connection con = jdbcTemplate.getDataSource().getConnection();
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1,shippingDtaEmp.getIdshippingorder());

            ResultSet rs = ps.executeQuery();
                r.setIdshippingorder(rs.getInt("idshippingorder"));
                r.setNamedepartament(rs.getString("namedepartment"));
                r.setNameprovincia(rs.getString("nameprovincia"));
                r.setNamedistrict(rs.getString("namedistrict"));
                r.setNombreEmpleado(rs.getString("nombreEmpleado"));
            ps.close();
            rs.close();
            con.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return r;
    }

    public SearchProductCatalog getProductOrders(ShippingDtaEmp shippingDtaEmp) {
        SearchProductCatalog r = new SearchProductCatalog();
        r.setListProductCatalog(new ArrayList<ProductCatalog>());
        String SQL = "Select pct.productmodel, pct.productbrand, pct.productdescription, \n" +
                "        pca.amount, pct.unitprice \n" +
                "from shippingorder shi,shippingstate sst, assignment ass, purcharse pur, productscart pca, productcatalog pct \n" +
                "where shi.idasignacion = ass.idassignment \n" +
                "and shi.idshippingstate = sst.idshippingstate \n" +
                "and ass.idpurcharse = pur.idpurcharse \n" +
                "and pur.idproductoscart = pca.idproductscart \n" +
                "and pca.idproductcatalog = pct.idproductcatalog \n" +
                "and shi.idshippingorder = ?; \n ";
        try {
            Connection con = jdbcTemplate.getDataSource().getConnection();
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1,shippingDtaEmp.getIdshippingorder());

            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                ProductCatalog p = new ProductCatalog();
                p.setProductModel(rs.getString("productmodel"));
                p.setProductBrand(rs.getString("productbrand"));
                p.setProductdescription(rs.getString("productdescription"));
                p.setAmount(rs.getInt("amount"));
                p.setUnitprice(rs.getFloat("unitprice"));
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
