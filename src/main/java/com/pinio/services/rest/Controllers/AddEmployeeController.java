package com.pinio.services.rest.Controllers;

import com.pinio.services.Models.Entity.Employees;
import com.pinio.services.Service.AddEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*",methods = {RequestMethod.POST,RequestMethod.GET})
@RequestMapping("/employee")
public class AddEmployeeController {
    @Autowired
    private AddEmployeeService service;
    @RequestMapping(
            value= "/addemployee",
            produces = "application/json;charset=utf-8",
            method = RequestMethod.POST
    )
    public @ResponseBody
    Employees addNewEmployee (@RequestBody Employees employees){
        return service.addNewEmployee(employees);
    }
}
