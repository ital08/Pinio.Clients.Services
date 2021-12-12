package com.pinio.services.Service;

import com.pinio.services.Models.Entity.Employees;
import com.pinio.services.Models.Entity.SearchEmployees;

public interface EmployeesListService {
    //Listado de empleados y busqueda de empleados por id y nombre, tambien cambio de rol
    public abstract SearchEmployees getEmployees(Integer integer);
    public abstract SearchEmployees getEmployees(Employees employees, Integer integer);
    public abstract SearchEmployees getEmployees(Employees employees);
    public abstract Employees changeEmployeeRol(Employees employees);
}
