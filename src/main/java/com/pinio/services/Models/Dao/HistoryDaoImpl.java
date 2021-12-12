package com.pinio.services.Models.Dao;

import com.pinio.services.Models.Entity.ProductCatalog;
import com.pinio.services.Models.Entity.SearchProductCatalog;
import com.pinio.services.Models.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@Repository
public class HistoryDaoImpl implements HistoryDao{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public SearchProductCatalog getHistorial(User user) {
        SearchProductCatalog r = new SearchProductCatalog();
        r.setListProductCatalog(new ArrayList<ProductCatalog>());
        String SQL = "Select pct.idproductcatalog, pct.productbrand, pct.productmodel, pct.productdescription, pct.unitprice, pca.amount, \n" +
                "        dep.namedepartment, pro.nameprovincia, dis.namedistrict, pur.purcharsedate, adr.postalcode, \n" +
                "        adr.referencia \n" +
                "from department dep, province pro,district dis, assignment ass, \n" +
                "        purcharse pur, productscart pca, productcatalog pct, shoppinghistory shh, \n" +
                "        client cli, adress adr \n" +
                "where dep.iddepartment = pro.iddepartment \n" +
                "        and  pro.idprovince = dis.idprovince \n" +
                "        and  dis.iddistrict = adr.iddistrict \n" +
                "        and  ass.idpurcharse = pur.idpurcharse \n" +
                "        and  pur.idproductoscart = pca.idproductscart \n" +
                "        and  pca.idproductcatalog = pct.idproductcatalog \n" +
                "        and adr.idemailadress = cli.emailadress \n" +
                "        and shh.idclient=cli.idclient \n" +
                "        and cli.idclient = ?; \n ";
        try {
            Connection con = jdbcTemplate.getDataSource().getConnection();
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setString(1,user.getIdclient());

            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                ProductCatalog p = new ProductCatalog();
                p.setProductModel(rs.getString("productmodel"));
                p.setUnitprice(rs.getFloat("unitprice"));
                p.setAmount(rs.getInt("amount"));
                p.setFinalCost(rs.getFloat("unitprice") * rs.getInt("amount"));
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
