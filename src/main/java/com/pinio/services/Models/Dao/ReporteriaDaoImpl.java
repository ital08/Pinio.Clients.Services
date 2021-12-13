package com.pinio.services.Models.Dao;

import com.pinio.services.Models.Entity.SearchSelsReg;
import com.pinio.services.Models.Entity.SelsReg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@Repository
public class ReporteriaDaoImpl implements ReporteriaDao{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public SearchSelsReg getVentasDistrito() {
        SearchSelsReg r = new SearchSelsReg();
        r.setListSelsReg(new ArrayList<SelsReg>());
        String SQL = "SELECT Count (IdDistrict), Sum(Amount), nameDistrict \n " +
                "FROM SelsReg \n " +
                "GROUP BY nameDistrict;  ";
        try {
            Connection con = jdbcTemplate.getDataSource().getConnection();
            PreparedStatement ps = con.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                SelsReg p = new SelsReg();
                p.setAmount(rs.getFloat("Sum"));
                p.setVentas(rs.getInt("Count"));
                p.setNamedistrict(rs.getNString("nameDistrict"));
                r.getListSelsReg().add(p);
            }
            ps.close();
            rs.close();
            con.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return r;
    }

    public SearchSelsReg getVentasProvincia() {
        SearchSelsReg r = new SearchSelsReg();
        r.setListSelsReg(new ArrayList<SelsReg>());
        String SQL = "SELECT Count (idProvince), Sum(Amount), nameProvincia \n " +
                "FROM SelsReg \n " +
                "GROUP BY nameProvincia; ";
        try {
            Connection con = jdbcTemplate.getDataSource().getConnection();
            PreparedStatement ps = con.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                SelsReg p = new SelsReg();
                p.setAmount(rs.getFloat("Sum"));
                p.setVentas(rs.getInt("Count"));
                p.setNameprovince(rs.getString("nameProvincia"));
                r.getListSelsReg().add(p);
            }
            ps.close();
            rs.close();
            con.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return r;
    }

    public SearchSelsReg getVentasDepartamento() {
        SearchSelsReg r = new SearchSelsReg();
        r.setListSelsReg(new ArrayList<SelsReg>());
        String SQL = "SELECT Count (IdDepartment), Sum(Amount) , nameDepartment \n " +
                "FROM SelsReg \n " +
                "group by namedepartment;  ";
        try {
            Connection con = jdbcTemplate.getDataSource().getConnection();
            PreparedStatement ps = con.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                SelsReg p = new SelsReg();
                p.setAmount(rs.getFloat("Sum"));
                p.setVentas(rs.getInt("Count"));
                p.setNamedepartment(rs.getString("nameDepartment"));
                r.getListSelsReg().add(p);
            }
            ps.close();
            rs.close();
            con.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return r;
    }

    public Integer getUsuariosNuevos() {
        Integer r = null;
        String SQL = "SELECT count(*) from Client \n " +
                "where  EXTRACT(month from client.clientregistrydate)=EXTRACT(month from current_date); \n  ";
        try {
            Connection con = jdbcTemplate.getDataSource().getConnection();
            PreparedStatement ps = con.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();
            r = rs.getInt("Count");
            ps.close();
            rs.close();
            con.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return r;
    }

    public Integer getUsuariosTotales() {
        Integer r = null;
        String SQL = "SELECT count(*) from Client; ";
        try {
            Connection con = jdbcTemplate.getDataSource().getConnection();
            PreparedStatement ps = con.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();
            r = rs.getInt("Count");
            ps.close();
            rs.close();
            con.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return r;
    }

    public SearchSelsReg getVentasDiariasMesActual() {
        SearchSelsReg r = new SearchSelsReg();
        r.setListSelsReg(new ArrayList<SelsReg>());
        String SQL = "SELECT count(*),sum(amount),EXTRACT(day from PURCHARSE.PURCHARSEDATE)AS Dia,EXTRACT(month from PURCHARSE.PURCHARSEDATE) As mes,EXTRACT(Year from PURCHARSE.PURCHARSEDATE) As anio FROM PURCHARSE \n " +
                "GROUP BY EXTRACT(day from PURCHARSE.PURCHARSEDATE),EXTRACT(month from PURCHARSE.PURCHARSEDATE),EXTRACT(Year from PURCHARSE.PURCHARSEDATE) \n " +
                "HAVING EXTRACT(month from PURCHARSE.PURCHARSEDATE)= EXTRACT(month from current_Date) and EXTRACT(year from PURCHARSE.PURCHARSEDATE)= EXTRACT(year from current_Date); \n ";
        try {
            Connection con = jdbcTemplate.getDataSource().getConnection();
            PreparedStatement ps = con.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                SelsReg p = new SelsReg();
                p.setAmount(rs.getFloat("Sum"));
                p.setVentas(rs.getInt("Count"));
                p.setDay(rs.getInt("Dia"));
                p.setMonth(rs.getInt("Mes"));
                p.setAnio(rs.getInt("anio"));
                r.getListSelsReg().add(p);
            }
            ps.close();
            rs.close();
            con.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return r;
    }

    public SearchSelsReg getVentasDiariasMes(Integer integer) {
        SearchSelsReg r = new SearchSelsReg();
        r.setListSelsReg(new ArrayList<SelsReg>());
        String SQL = "SELECT count(*),sum(amount),EXTRACT(day from PURCHARSE.PURCHARSEDATE)AS Dia,EXTRACT(month from PURCHARSE.PURCHARSEDATE) As mes,EXTRACT(Year from PURCHARSE.PURCHARSEDATE) As anio FROM PURCHARSE\n" +
                "GROUP BY EXTRACT(day from PURCHARSE.PURCHARSEDATE),EXTRACT(month from PURCHARSE.PURCHARSEDATE),EXTRACT(Year from PURCHARSE.PURCHARSEDATE) \n" +
                "HAVING EXTRACT(month from PURCHARSE.PURCHARSEDATE)= ? and EXTRACT(year from PURCHARSE.PURCHARSEDATE)= EXTRACT(year from current_Date);\n";
        try {
            Connection con = jdbcTemplate.getDataSource().getConnection();
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1,integer);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                SelsReg p = new SelsReg();
                p.setAmount(rs.getFloat("Sum"));
                p.setVentas(rs.getInt("Count"));
                p.setDay(rs.getInt("Dia"));
                p.setMonth(rs.getInt("Mes"));
                p.setAnio(rs.getInt("anio"));
                r.getListSelsReg().add(p);
            }
            ps.close();
            rs.close();
            con.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return r;
    }

    public SelsReg getVentadelDia() {
        SelsReg r = new SelsReg();
        String SQL = "SELECT count(*), Sum(Amount) from purcharse \n " +
                "where purcharse.purcharsedate BETWEEN current_date AND current_date+1; \n ";
        try {
            Connection con = jdbcTemplate.getDataSource().getConnection();
            PreparedStatement ps = con.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                r.setAmount(rs.getFloat("Sum"));
                r.setVentas(rs.getInt("Count"));}
            ps.close();
            rs.close();
            con.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return r;
    }

    public SearchSelsReg getVentasMendualesAnioActual() {
        SearchSelsReg r = new SearchSelsReg();
        r.setListSelsReg(new ArrayList<SelsReg>());
        String SQL = "SELECT count(*),sum(amount),EXTRACT(month from PURCHARSE.PURCHARSEDATE) AS Mes, EXTRACT(Year from PURCHARSE.PURCHARSEDATE) As anio FROM PURCHARSE \n " +
                "GROUP BY EXTRACT(month from PURCHARSE.PURCHARSEDATE),EXTRACT(YEAR from PURCHARSE.PURCHARSEDATE) \n " +
                "HAVING EXTRACT(YEAR from PURCHARSE.PURCHARSEDATE)= EXTRACT(YEAR from current_Date); \n ";
        try {
            Connection con = jdbcTemplate.getDataSource().getConnection();
            PreparedStatement ps = con.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                SelsReg p = new SelsReg();
                p.setAmount(rs.getFloat("Sum"));
                p.setVentas(rs.getInt("Count"));
                p.setMonth(rs.getInt("Mes"));
                p.setAnio(rs.getInt("anio"));
                r.getListSelsReg().add(p);
            }
            ps.close();
            rs.close();
            con.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return r;
    }

    public SearchSelsReg getVentasMendualesAnio(Integer integer) {
        SearchSelsReg r = new SearchSelsReg();
        r.setListSelsReg(new ArrayList<SelsReg>());
        String SQL = "SELECT count(*),sum(amount),EXTRACT(month from PURCHARSE.PURCHARSEDATE) AS Mes, EXTRACT(Year from PURCHARSE.PURCHARSEDATE) As anio FROM PURCHARSE \n " +
                "GROUP BY EXTRACT(month from PURCHARSE.PURCHARSEDATE),EXTRACT(YEAR from PURCHARSE.PURCHARSEDATE) \n " +
                "HAVING EXTRACT(YEAR from PURCHARSE.PURCHARSEDATE)= ?; \n ";
        try {
            Connection con = jdbcTemplate.getDataSource().getConnection();
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1,integer);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                SelsReg p = new SelsReg();
                p.setAmount(rs.getFloat("Sum"));
                p.setVentas(rs.getInt("Count"));
                p.setMonth(rs.getInt("Mes"));
                p.setAnio(rs.getInt("anio"));
                r.getListSelsReg().add(p);
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
