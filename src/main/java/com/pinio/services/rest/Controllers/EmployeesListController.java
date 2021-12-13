package com.pinio.services.rest.Controllers;

import com.pinio.services.Models.Entity.*;
import com.pinio.services.Service.EmployeesListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@CrossOrigin(origins = "*",methods = {RequestMethod.POST,RequestMethod.GET})
@RequestMapping("/products")
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
