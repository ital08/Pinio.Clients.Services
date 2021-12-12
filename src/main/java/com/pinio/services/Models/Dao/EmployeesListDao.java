package com.pinio.services.Models.Dao;

import com.pinio.services.Models.Entity.Employees;
import com.pinio.services.Models.Entity.SearchEmployees;

public interface EmployeesListDao {

    public abstract SearchEmployees getEmployees(Integer integer);
    public abstract SearchEmployees getEmployees(Employees employees, Integer integer);
    public abstract SearchEmployees getEmployees(Employees employees);
    public abstract Employees changeEmployeeRol(Employees employees);
}
