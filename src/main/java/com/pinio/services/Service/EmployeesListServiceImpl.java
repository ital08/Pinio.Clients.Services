package com.pinio.services.Service;

import com.pinio.services.Models.Dao.EmployeesListDao;
import com.pinio.services.Models.Entity.Employees;
import com.pinio.services.Models.Entity.SearchEmployees;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service("EmployeesListServiceImpl")
public class EmployeesListServiceImpl implements EmployeesListService{
    @Autowired
    private EmployeesListDao dao;
    public SearchEmployees getEmployees(Integer integer) {
        return dao.getEmployees(integer);
    }
    public SearchEmployees getEmployees(Employees employees, Integer integer) {
        return dao.getEmployees(employees,integer);
    }
    public SearchEmployees getEmployees(Employees employees) {
        return dao.getEmployees(employees);
    }
    public Employees changeEmployeeRol(Employees employees) {
        return dao.changeEmployeeRol(employees);
    }
}
