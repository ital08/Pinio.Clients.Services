package com.pinio.services.rest.Controllers;

import com.pinio.services.Models.Entity.*;
import com.pinio.services.Service.FiltersListServiceImpl;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*",methods = {RequestMethod.POST,RequestMethod.GET})
@RequestMapping("/filterslist")
public class FiltersListController {
    @Autowired
    private FiltersListServiceImpl service;

    @RequestMapping(
            value = "/obtainBrands",
            produces = "application/json;charset=utf-8",
            method = RequestMethod.GET
    )
    public @ResponseBody
    SearchBrand obtainBrands(){
        return service.obtainBrands();
    }

    @RequestMapping(
            value = "/obtainCategories",
            produces = "application/json;charset=utf-8",
            method = RequestMethod.GET
    )
    public @ResponseBody
    SearchCategory obtainCategories(){
        return service.obtainCategories();
    }

    @RequestMapping(
            value = "/obtainSubcategories",
            produces = "application/json;charset=utf-8",
            method = RequestMethod.GET
    )
    public @ResponseBody
    SearchSubcategory obtainBrands(@RequestBody Category category){
        return service.obtainSubcategories(category);
    }
}
