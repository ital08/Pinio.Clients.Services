package com.pinio.services.Service;

import com.pinio.services.Models.Entity.Employees;

public interface AddEmployeeService {
    //Añadir un nuevo Empleado
    public abstract Employees addNewEmployee(Employees employees);
}
