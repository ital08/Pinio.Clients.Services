package com.pinio.services.Models.Entity;

import lombok.Data;

import java.awt.*;

@Data
public class Products {
//    CREATE TABLE public.productcatalog (
//            idproductcatalog varchar(10) NOT NULL,
//    idsubcategory integer NOT NULL,
//    idimagescatalog varchar(9) NOT NULL,
//    productbrand varchar(20) NOT NULL,
//    productmodel varchar(20) NOT NULL,
//    productdescription varchar(200) NOT NULL,
//    provider varchar(30) NOT NULL,
//    unitprice numeric(10,2) NOT NULL,
//    unitsxlot integer NOT NULL,
//    launchdate timestamp with time zone NOT NULL,
//    shippingcost numeric(10,2) NOT NULL,
//    PRIMARY KEY (idproductcatalog)
    private String idProductCatalog;
    private Integer idSubCategory;
//    private List<ImagesCatalog> Images;
}
