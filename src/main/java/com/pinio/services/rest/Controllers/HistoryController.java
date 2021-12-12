package com.pinio.services.rest.Controllers;

import com.pinio.services.Models.Entity.SearchProductCatalog;
import com.pinio.services.Models.Entity.User;
import com.pinio.services.Service.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*",methods = {RequestMethod.POST,RequestMethod.GET})
public class HistoryController {
    @Autowired
    private HistoryService service;
    @RequestMapping(
            value= "/History",
            produces = "application/json;charset=utf-8",
            method = RequestMethod.GET
    )
    public @ResponseBody
    SearchProductCatalog getHistorial(@RequestBody User user){
        return service.getHistorial(user);
    }
}
