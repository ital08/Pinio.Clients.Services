package com.pinio.services.Models.Dao;

import com.pinio.services.Models.Entity.LoginUser;
import com.pinio.services.Models.Entity.ProductCatalog;
import com.pinio.services.Models.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
@Component
public class UserServiceDaoImpl implements UserServiceDao{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public User login(LoginUser loginuser) {
        User p = new User();
        String SQL = "SELECT \n" +
                "c.idclient,\n" +
                "c.dni,\n" +
                "c.clientname,\n" +
                "c.email,\n" +
                "c.clientpassword\n" +
                "FROM client as c \n" +
                "WHERE (c.email = ?) AND (c.clientpassword = ?);";
        try {
            Connection con = jdbcTemplate.getDataSource().getConnection();
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setString(1,loginuser.getClientemail());

            ps.setString(2, loginuser.getClientpassword());

            ResultSet rs = ps.executeQuery();
            while(rs.next()){

                p.setClientname(rs.getString("clientname"));
                p.setDNI(rs.getString("dni"));
                p.setIdclient(rs.getString("idclient"));
                p.setClientpassword(rs.getString("clientpassword"));
                p.setClientemail(rs.getString("email"));
            }
            ps.close();
            rs.close();
            con.close();

        } catch (SQLException throwables) {
            System.out.println("'"+loginuser.getClientemail()+"'");
            System.out.println(loginuser.getClientemail());
            throwables.printStackTrace();


        }
        return p;
    }
}
