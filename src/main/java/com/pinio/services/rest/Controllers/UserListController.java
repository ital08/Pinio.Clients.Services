package com.pinio.services.rest.Controllers;

import com.pinio.services.Models.Entity.SearchUsers;
import com.pinio.services.Models.Entity.User;
import com.pinio.services.Service.UserListService;
import org.springframework.beans.factory.annotation.Autowired;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*",methods = {RequestMethod.POST,RequestMethod.GET})
@RequestMapping("/userlist")
public class UserListController {
    @Autowired
    private UserListService service;
    @RequestMapping(
            value = "/userlistpaged",
            produces = "application/json;charset=utf-8",
            method = RequestMethod.GET
    )
    public @ResponseBody
    SearchUsers getUsers(@RequestBody Integer integer){
        return service.getUsers(integer);
    }
    @RequestMapping(
            value = "/userlistporID",
            produces = "application/json;charset=utf-8",
            method = RequestMethod.GET
    )
    public @ResponseBody
    SearchUsers getUsers(@RequestBody User user){
        return service.getUsers(user);
    }
    @RequestMapping(
            value = "/userlistporNombre",
            produces = "application/json;charset=utf-8",
            method = RequestMethod.GET
    )
    public @ResponseBody
    SearchUsers getUsers(@RequestBody User user, Integer integer){
        return service.getUsers(user, integer);
    }
}
