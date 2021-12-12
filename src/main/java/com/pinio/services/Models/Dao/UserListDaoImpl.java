package com.pinio.services.Models.Dao;

import com.pinio.services.Models.Entity.SearchUsers;
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
public class UserListDaoImpl implements UserListDao{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public SearchUsers getUsers(Integer integer) {
        SearchUsers r = new SearchUsers();
        r.setListUsers(new ArrayList<User>());
        String SQL = "SELECT * FROM PaginadoClients(?,10); ";
        try {
            Connection con = jdbcTemplate.getDataSource().getConnection();
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1,integer);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                User p = new User();
                p.setIdclient(rs.getString("idclient"));
                p.setDNI(rs.getString("dni"));
                p.setClientname(rs.getString("clientname"));
                p.setClientLastname(rs.getString("clientlastname"));
                p.setNameDistrict(rs.getString("namedistrict"));
                p.setClientemail(rs.getString("email"));
                r.getListUsers().add(p);
            }
            ps.close();
            rs.close();
            con.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return r;
    }

    public SearchUsers getUsers(User user) {
        SearchUsers r = new SearchUsers();
        r.setListUsers(new ArrayList<User>());
        String SQL = " SELECT * \n " +
                "   FROM ClientDta \n " +
                "   WHERE IdClient = ?; ";
        try {
            Connection con = jdbcTemplate.getDataSource().getConnection();
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setString(1,user.getIdclient());
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                User p = new User();
                p.setIdclient(rs.getString("idclient"));
                p.setDNI(rs.getString("dni"));
                p.setClientname(rs.getString("clientname"));
                p.setClientLastname(rs.getString("clientlastname"));
                p.setNameDistrict(rs.getString("namedistrict"));
                p.setClientemail(rs.getString("email"));
                r.getListUsers().add(p);
            }
            ps.close();
            rs.close();
            con.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return r;
    }

    public SearchUsers getUsers(User user, Integer integer) {
        SearchUsers r = new SearchUsers();
        r.setListUsers(new ArrayList<User>());
        String SQL = "SELECT * \n " +
                "   FROM ClientDta \n " +
                "   WHERE upper(ClientDta.name LIKE %?%) \n " +
                "   ORDER BY IdClient \n " +
                "   LIMIT 10 \n  " +
                "OFFSET ((? - 1)*10);   ";
        try {
            Connection con = jdbcTemplate.getDataSource().getConnection();
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setString(1,user.getClientname());
            ps.setInt(2,integer);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                User p = new User();
                p.setIdclient(rs.getString("idclient"));
                p.setDNI(rs.getString("dni"));
                p.setClientname(rs.getString("clientname"));
                p.setClientLastname(rs.getString("clientlastname"));
                p.setNameDistrict(rs.getString("namedistrict"));
                p.setClientemail(rs.getString("email"));
                r.getListUsers().add(p);
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
