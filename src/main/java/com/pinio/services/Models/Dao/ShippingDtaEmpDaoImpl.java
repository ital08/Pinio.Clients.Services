package com.pinio.services.Models.Dao;

import com.pinio.services.Models.Entity.SearchShippingDtaEmp;
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
public class ShippingDtaEmpDaoImpl implements ShippingDtaEmpDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public SearchShippingDtaEmp getShippingDtaEmp() {
        SearchShippingDtaEmp r = new SearchShippingDtaEmp();
        r.setListShippingDtaEmp(new ArrayList<ShippingDtaEmp>());
        String SQL = "Select idshippingorder, idemployee, nombreEmpleado, namedepartment, nameprovincia, namedistrict, shippingstatename \n" +
                "from shippingDtaEmp;\n";
        try {
            Connection con = jdbcTemplate.getDataSource().getConnection();
            PreparedStatement ps = con.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                ShippingDtaEmp p = new ShippingDtaEmp();
                p.setIdshippingorder(rs.getInt("idshippingorder"));
                p.setIdemployee(rs.getInt("idemployee"));
                p.setNombreEmpleado(rs.getString("nombreEmpleado"));
                p.setNamedepartament(rs.getString("namedepartment"));
                p.setNameprovincia(rs.getString("nameprovincia"));
                p.setNamedistrict(rs.getNString("namedistrict"));
                p.setShippingstatename(rs.getNString("shippingstatename"));
                r.getListShippingDtaEmp().add(p);
            }
            ps.close();
            rs.close();
            con.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return r;
    }

    public ShippingDtaEmp chageShippingState(ShippingDtaEmp shippingDtaEmp) {
        String SQL = "Update shippingorder\n " +
                "      set idshippingstate = ? \n " +
                "      where idshippingorder = ? ; \n";
        try{
            Connection con = jdbcTemplate.getDataSource().getConnection();
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setString(1, shippingDtaEmp.getShippingstatename());
            ps.setInt(2, shippingDtaEmp.getIdshippingorder());
            ps.executeUpdate();
            ps.close();
            con.commit();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return shippingDtaEmp;
    }
}
