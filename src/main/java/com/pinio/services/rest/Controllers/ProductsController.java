package com.pinio.services.rest.Controllers;

import com.pinio.services.Models.Entity.ProductCatalog;
import com.pinio.services.Models.Entity.SearchProductCatalog;
import com.pinio.services.Models.Entity.Subcategory;
import com.pinio.services.Service.ProductsCatalogService;
import io.swagger.v3.oas.annotations.Operation;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@CrossOrigin(origins = "*",methods = {RequestMethod.POST,RequestMethod.GET})
@RequestMapping("/products")
public class ProductsController {
    @Autowired
    private ProductsCatalogService service;

    @RequestMapping(
            value = "/productcatalog",
            produces = "application/json;charset=utf-8",
            method = RequestMethod.GET
    )
    public @ResponseBody SearchProductCatalog getProductCatalog (@RequestBody ProductCatalog productCatalog,String orden,Integer pagNum,Integer pagSize){
        return service.getProductCatalog(productCatalog,orden,pagNum,pagSize);
    }
    @RequestMapping(
            value = "/productcatalogsub",
            produces = "application/json;charset=utf-8",
            method = RequestMethod.GET
    )
    public @ResponseBody SearchProductCatalog getProductCatalogSub (@RequestBody Subcategory subcategory, String orden, Integer pagNum, Integer pagSize){
        return service.getProductCatalogSub(subcategory,orden,pagNum,pagSize);
    }

    @RequestMapping(
            value = "/productcatalogprice",
            produces = "application/json;charset=utf-8",
            method = RequestMethod.GET
    )
    public @ResponseBody SearchProductCatalog getProductCatalogPrice ( String orden,Integer pagNum,Integer pagSize,Integer min,Integer max){
        return service.getProductCatalogPrice(orden,pagNum,pagSize,min,max);
    }

    @RequestMapping(
            value = "/productcatalogbrand",
            produces = "application/json;charset=utf-8",
            method = RequestMethod.GET
    )
    public @ResponseBody SearchProductCatalog getProductCatalogBrand (@RequestBody ProductCatalog productCatalog,String orden,Integer pagNum,Integer pagSize){
        return service.getProductCatalogBrand(productCatalog,orden,pagNum,pagSize);
    }
}
