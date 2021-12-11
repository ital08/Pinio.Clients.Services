package com.pinio.services.rest.Controllers;

import com.pinio.services.Models.Entity.SearchShippingDtaEmp;
import com.pinio.services.Models.Entity.ShippingDtaEmp;
import com.pinio.services.Service.ShippingDtaEmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*",methods = {RequestMethod.POST,RequestMethod.GET})

public class ShippingDtaEmpController {
    @Autowired
    private ShippingDtaEmpService service;
    @RequestMapping(
            value = "/ShippingDtaEmp",
            produces = "application/json;charset=utf-8",
            method = RequestMethod.GET
    )
    public @ResponseBody
    SearchShippingDtaEmp SearchShippingDtaEmp (){
        return service.getShippingDtaEmp();
    }

    @RequestMapping(
            value = "/ChangeShippingStte",
            produces = "application/json;charset=utf-8",
            method = RequestMethod.POST
    )
    public @ResponseBody
    ShippingDtaEmp chageShippingState (ShippingDtaEmp shippingDtaEmp){
        return service.chageShippingState(shippingDtaEmp);
    }
}
