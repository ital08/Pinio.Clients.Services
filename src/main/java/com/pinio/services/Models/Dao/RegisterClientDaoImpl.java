package com.pinio.services.Models.Dao;

import com.pinio.services.Models.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

@Repository
public class RegisterClientDaoImpl implements RegisterClientDao{
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public User registerNewClient(User user){
        String SQL = "INSERT into client \n" +
                "   (idclient, emailadress, dni, clientpassword, clientname, \n" +
                "   clientlastname, email,clientregistrydate) \n" +
                "values (?, ?, ?, ?, ?, ?, ?, ?); \n";
        try{
            Connection con = jdbcTemplate.getDataSource().getConnection();
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1, user.getIdclient());
            ps.setInt(2, user.getEmailadress());
            ps.setInt(3, user.getDNI());
            ps.setString(4, user.getClientpassword());
            ps.setString(5, user.getClientname());
            ps.setString(6, user.getClientlastname());
            ps.setString(7, user.getClientemail());

            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.HOUR, 0);
            calendar.set(Calendar.MINUTE, 0);
            calendar.set(Calendar.SECOND, 0);
            calendar.set(Calendar.MILLISECOND, 0);
            Date today = calendar.getTime();
            Timestamp now = new Timestamp(today.getTime());
            ps.setTimestamp(8,now);

            ps.executeUpdate();
            ps.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
}
