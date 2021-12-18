package com.pinio.services.Models.Dao;

import com.pinio.services.Models.Entity.Employees;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Repository
public class AddEmployeeDaoImpl implements AddEmployeeDao{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Employees addNewEmployee(Employees employees) {
        String SQL = "INSERT INTO Employees (Name, LastName, password, EmailEmployee,idJob,idemployee) \n " +
                "values (?,?,?,?,?,?); \n ";
        try{
            Connection con = jdbcTemplate.getDataSource().getConnection();
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setString(1, employees.getName());
            ps.setString(2, employees.getLastname());
            ps.setString(3, employees.getPassword());
            ps.setString(4, employees.getEmailemployee());
            ps.setInt(5, employees.getIdjob());
            ps.setInt(6, employees.getIdemployee());
            ps.executeUpdate();
            ps.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employees;
    }
}
