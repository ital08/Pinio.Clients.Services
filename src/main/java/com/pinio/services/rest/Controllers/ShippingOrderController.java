package com.pinio.services.rest.Controllers;

import com.pinio.services.Models.Entity.SearchProductCatalog;
import com.pinio.services.Models.Entity.ShippingDtaEmp;
import com.pinio.services.Service.ShippingOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*",methods = {RequestMethod.POST,RequestMethod.GET})
public class ShippingOrderController {
    @Autowired
    private ShippingOrderService service;
    @RequestMapping(
            value = "/ShippingOrder",
            produces = "application/json;charset=utf-8",
            method = RequestMethod.GET
    )
    public @ResponseBody
    ShippingDtaEmp getShippingOrders(@RequestBody ShippingDtaEmp shippingDtaEmp){
        return service.getShippingOrders(shippingDtaEmp);
    }

    @RequestMapping(
            value = "/ProductOrders",
            produces = "application/json;charset=utf-8",
            method = RequestMethod.GET
    )
    public @ResponseBody
    SearchProductCatalog getProductOrders(@RequestBody ShippingDtaEmp shippingDtaEmp){
        return service.getProductOrders(shippingDtaEmp);
    }
}
