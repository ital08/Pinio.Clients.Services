package com.pinio.services.Models.Entity;

import lombok.Data;

import java.util.List;

@Data
public class ProductCatalog {
//    CREATE TABLE productcatalog (
//            idproductcatalog varchar(10) NOT NULL,
//    idsubcategory integer NOT NULL,
//    productbrand varchar(50) NOT NULL,
//    productmodel varchar(50) NOT NULL,
//    productdescription varchar(1000) NOT NULL,
//    provider varchar(50) NOT NULL,
//    unitprice numeric(10,2) NOT NULL,
//    unitsxlot integer NOT NULL,
//    launchdate TIMESTAMPTZ NOT NULL DEFAULT NOW(),
//    shippingcost numeric(10,2) NOT NULL,
//    PRIMARY KEY (idproductcatalog)
//);
    private String idProductCatalog;
    private Integer idsubcategory;
    private String productBrand;
    private String productModel;
    private String productdescription;
    private String provider;
    private Float unitprice;
    private Integer unitsxlot;
    private Float shippingcost;
    private String urlimage;
}
