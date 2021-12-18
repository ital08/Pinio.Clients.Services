package com.pinio.services.rest.Controllers;

import com.pinio.services.Models.Entity.ProductLot;
import com.pinio.services.Service.ProductLotService;
import org.springframework.beans.factory.annotation.Autowired;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*",methods = {RequestMethod.POST,RequestMethod.GET})
@RequestMapping("/products")
public class ProductLotController {
    @Autowired
    private ProductLotService service;
    @RequestMapping(
            value= "/addproductlot",
            produces = "application/json;charset=utf-8",
            method = RequestMethod.POST
    )
    public @ResponseBody
    ProductLot addProductLot (ProductLot productLot){
        return service.addProductLot(productLot);
    }
}
