package com.pinio.services.Models.Dao;

import com.pinio.services.Models.Entity.Employees;
import com.pinio.services.Models.Entity.SearchEmployees;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@Repository
public class EmployeesListDaoImpl implements EmployeesListDao{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public SearchEmployees getEmployees(Integer integer) {
        SearchEmployees r = new SearchEmployees();
        r.setListEmployees(new ArrayList<Employees>());
        String SQL = "SELECT * FROM PaginadoEmployees(?,10); ";
        try {
            Connection con = jdbcTemplate.getDataSource().getConnection();
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1,integer);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Employees p = new Employees();
                p.setIdemployee(rs.getInt("idemployee"));
                p.setName(rs.getString("name"));
                p.setLastname(rs.getString("lastname"));
                p.setCreateddate(rs.getString("createddate"));
                p.setEmailemployee(rs.getString("emailemployee"));
                p.setIdjob(rs.getInt("idjob"));
                r.getListEmployees().add(p);
            }
            ps.close();
            rs.close();
            con.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return r;
    }

    public SearchEmployees getEmployees(Employees employees) {
        SearchEmployees r = new SearchEmployees();
        r.setListEmployees(new ArrayList<Employees>());
        String SQL = "SELECT * \n " +
                "   FROM EmplDta \n " +
                "   WHERE IdEmployee = ?; ";
        try {
            Connection con = jdbcTemplate.getDataSource().getConnection();
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1,employees.getIdemployee());
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Employees p = new Employees();
                p.setIdemployee(rs.getInt("idemployee"));
                p.setName(rs.getString("name"));
                p.setLastname(rs.getString("lastname"));
                p.setCreateddate(rs.getString("createddate"));
                p.setEmailemployee(rs.getString("emailemployee"));
                p.setIdjob(rs.getInt("idjob"));
                r.getListEmployees().add(p);
            }
            ps.close();
            rs.close();
            con.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return r;
    }


    public SearchEmployees getEmployees(Employees employees, Integer integer) {
        SearchEmployees r = new SearchEmployees();
        r.setListEmployees(new ArrayList<Employees>());
        String SQL = "SELECT * \n " +
                "   FROM EmplDta \n " +
                "   WHERE upper(EmplDta.name) LIKE ?\n" +
                "   ORDER BY IdEmployee\n" +
                "   LIMIT 10 \n" +
                "   OFFSET ((?-1)*10);";
        try {
            Connection con = jdbcTemplate.getDataSource().getConnection();
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setString(1,"%"+employees.getName().toUpperCase()+"%");
            ps.setInt(2,integer);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Employees p = new Employees();
                p.setIdemployee(rs.getInt("idemployee"));
                p.setName(rs.getString("name"));
                p.setLastname(rs.getString("lastname"));
                p.setCreateddate(rs.getString("createddate"));
                p.setEmailemployee(rs.getString("emailemployee"));
                p.setIdjob(rs.getInt("idjob"));
                r.getListEmployees().add(p);
            }
            ps.close();
            rs.close();
            con.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return r;
    }

    public Employees changeEmployeeRol(Employees employees) {
        String SQL = "UPDATE EMPLOYEES \n " +
                "SET  IdJob = ? \n " +
                "WHERE IdEmployee = ?; ";
        try{
            Connection con = jdbcTemplate.getDataSource().getConnection();
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1, employees.getIdjob());
            ps.setInt(2, employees.getIdemployee());
            ps.executeUpdate();
            ps.close();
            con.commit();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employees;
    }
}
