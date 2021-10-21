package com.pinio.services.rest.Controllers;

import com.pinio.services.Models.Entity.ProductCatalog;
import com.pinio.services.Models.Entity.SearchProductCatalog;
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
@CrossOrigin(origins = "*",methods = {RequestMethod.POST})
@RequestMapping("/products")
public class ProductsController {
    @Autowired
    private ProductsCatalogService service;
    @GetMapping
    @Operation(summary = "Get status of application")
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Confirmation message that application is running",
                            content = @Content(mediaType = "text/plain"))
            }
    )
    @RequestMapping(
            value = "/status",
            produces = "application/json;charset=utf-8",
            method = RequestMethod.GET
    )
    public @ResponseBody ResponseEntity<String> example() {
        List<String> list = new ArrayList<>();
        //return a simple list of strings
        list.add("Congratulations, your application is up and running");
        return new ResponseEntity<String>(list.toString(), HttpStatus.OK);
    }
    @RequestMapping(
            value = "/productcatalog",
            produces = "application/json;charset=utf-8",
            method = RequestMethod.GET
    )
    public @ResponseBody SearchProductCatalog getProductCatalog (@RequestBody ProductCatalog productocatalog){
        return service.getProductCatalog(productocatalog);
    }
}
