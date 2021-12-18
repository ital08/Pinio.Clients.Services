package com.pinio.services.rest.Controllers;

import com.pinio.services.Models.Entity.SearchShippingDtaEmp;
import com.pinio.services.Models.Entity.ShippingDtaEmp;
import com.pinio.services.Service.ShippingDtaEmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*",methods = {RequestMethod.POST,RequestMethod.GET})
@RequestMapping("/shipping")
public class ShippingDtaEmpController {
    @Autowired
    private ShippingDtaEmpService service;
    @RequestMapping(
            value = "/shippingdtaemp",
            produces = "application/json;charset=utf-8",
            method = RequestMethod.GET
    )
    public @ResponseBody
    SearchShippingDtaEmp getShippingDtaEmp(){
        return service.getShippingDtaEmp();
    }

    @RequestMapping(
            value = "/changeshippingstate",
            produces = "application/json;charset=utf-8",
            method = RequestMethod.POST
    )
    public @ResponseBody
    ShippingDtaEmp changeShippingState (@RequestBody ShippingDtaEmp shippingDtaEmp){
        return service.changeShippingState(shippingDtaEmp);
    }
}
