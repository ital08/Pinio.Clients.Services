package com.pinio.services.rest.Controllers;

import com.pinio.services.Models.Entity.ProductCatalog;
import com.pinio.services.Models.Entity.ProductOrder;
import com.pinio.services.Service.ProductOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*",methods = {RequestMethod.POST,RequestMethod.GET})
public class ProductOrderController {
    @Autowired
    private ProductOrderService service;
    @RequestMapping(
            value= "/addproductorder",
            produces = "application/json;charset=utf-8",
            method = RequestMethod.POST
    )
    public @ResponseBody
    ProductOrder addProductOrder (@RequestBody ProductOrder productorder){
        return service.addProductOrder(productorder);
    }

}
