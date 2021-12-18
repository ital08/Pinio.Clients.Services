package com.pinio.services.rest.Controllers;


import com.pinio.services.Models.Entity.ProductCatalog;
import com.pinio.services.Models.Entity.SearchProductCatalog;
import com.pinio.services.Service.ShowProductService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*",methods = {RequestMethod.POST,RequestMethod.GET})
@RequestMapping("/showproduct")
public class ShowProductController {
    @Autowired
    private ShowProductService service;
    @RequestMapping(
            value = "/showproduct",
            produces = "application/json;charset=utf-8",
            method = RequestMethod.GET
    )
    public @ResponseBody ProductCatalog showProduct (@RequestBody ProductCatalog productCatalog){
        return service.showProduct(productCatalog);
    }
}
