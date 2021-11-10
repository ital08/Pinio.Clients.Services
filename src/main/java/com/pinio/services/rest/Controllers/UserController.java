package com.pinio.services.rest.Controllers;

import com.pinio.services.Models.Entity.LoginUser;
import com.pinio.services.Models.Entity.ProductCatalog;
import com.pinio.services.Models.Entity.SearchProductCatalog;
import com.pinio.services.Models.Entity.User;
import com.pinio.services.Service.ProductsCatalogService;
import com.pinio.services.Service.UserService;
import io.swagger.v3.oas.annotations.Operation;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@CrossOrigin(origins = "*",methods = {RequestMethod.POST,RequestMethod.GET})
@RequestMapping("/products")
public class UserController {
    @Autowired
    private UserService service;
    @RequestMapping(
            value = "/user",
            produces = "application/json;charset=utf-8",
            method = RequestMethod.GET
    )
    public @ResponseBody
    User login (@RequestBody LoginUser loginuser){
        return service.login(loginuser);
    }
}
