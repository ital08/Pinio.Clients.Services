package com.pinio.services.rest.Controllers;

import com.pinio.services.Models.Entity.ProductCatalog;
import com.pinio.services.Service.AddProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*",methods = {RequestMethod.POST,RequestMethod.GET})
public class AddProductController {
    @Autowired
    private AddProductService service;
    @RequestMapping(
            value= "/addproduct",
            produces = "application/json;charset=utf-8",
            method = RequestMethod.POST
    )
    public @ResponseBody
    ProductCatalog addNewProduct (@RequestBody ProductCatalog productcatalog){
        return service.addNewProduct(productcatalog);
    }
}
