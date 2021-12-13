package com.pinio.services.rest.Controllers;

import com.pinio.services.Models.Entity.SearchProductCatalog;
import com.pinio.services.Models.Entity.User;
import com.pinio.services.Service.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*",methods = {RequestMethod.POST,RequestMethod.GET})
@RequestMapping("/history")
public class HistoryController {
    @Autowired
    private HistoryService service;
    @RequestMapping(
            value= "/history",
            produces = "application/json;charset=utf-8",
            method = RequestMethod.GET
    )
    public @ResponseBody
    SearchProductCatalog getHistorial(@RequestBody User user){
        return service.getHistorial(user);
    }
}
