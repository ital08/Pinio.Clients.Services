package com.pinio.services.rest.Controllers;

import com.pinio.services.Models.Entity.ProductCatalog;
import com.pinio.services.Models.Entity.User;
import com.pinio.services.Service.AddProductService;
import com.pinio.services.Service.RegisterClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*",methods = {RequestMethod.POST,RequestMethod.GET})
@RequestMapping("/registerclient")
public class RegisterClientController {
    @Autowired
    private RegisterClientService service;
    @RequestMapping(
            value= "/registerclient",
            produces = "application/json;charset=utf-8",
            method = RequestMethod.POST
    )
    public @ResponseBody
    User registerNewClient(@RequestBody User user){
        return service.registerNewClient(user);
    }
}
