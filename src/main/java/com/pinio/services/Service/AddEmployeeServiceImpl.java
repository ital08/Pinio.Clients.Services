package com.pinio.services.Service;

import com.pinio.services.Models.Dao.AddEmployeeDao;
import com.pinio.services.Models.Entity.Employees;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service("AddEmployeeServiceImpl")
public class AddEmployeeServiceImpl implements AddEmployeeService{
    @Autowired
    private AddEmployeeDao dao;
    public Employees addNewEmployee(Employees employees) {
        return dao.addNewEmployee(employees);
    }
}
