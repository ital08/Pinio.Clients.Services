package com.pinio.services.rest.Controllers;

import com.pinio.services.Models.Entity.*;
import com.pinio.services.Service.EmployeesListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*",methods = {RequestMethod.POST,RequestMethod.GET})
public class EmployeesListController {
    @Autowired
    private EmployeesListService service;
    @RequestMapping(
            value = "/employeeslistpaged",
            produces = "application/json;charset=utf-8",
            method = RequestMethod.GET
    )
    public @ResponseBody
    SearchEmployees getEmployees(@RequestBody Integer integer){
        return service.getEmployees(integer);
    }
    @RequestMapping(
            value = "/employeeslistporID",
            produces = "application/json;charset=utf-8",
            method = RequestMethod.GET
    )
    public @ResponseBody
    SearchEmployees getEmployees(@RequestBody Employees employees){
        return service.getEmployees(employees);
    }
    @RequestMapping(
            value = "/employeeslistporNombre",
            produces = "application/json;charset=utf-8",
            method = RequestMethod.GET
    )
    public @ResponseBody
    SearchEmployees getEmployees(@RequestBody Employees employees, Integer integer){
        return service.getEmployees(employees, integer);
    }
    @RequestMapping(
            value = "/changeEmployeeRol",
            produces = "application/json;charset=utf-8",
            method = RequestMethod.POST
    )
    public @ResponseBody
    Employees changeEmployeeRol(@RequestBody Employees employees){
        return service.changeEmployeeRol(employees);
    }
}
