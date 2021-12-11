package com.pinio.services.Models.Entity;

import lombok.Data;

@Data
public class ProductOrder{
    //CREATE TABLE productorder (
    //    idproductorder integer NOT NULL,
    //    idproductcatalog varchar(10) NOT NULL,
    //    idemployee integer NOT NULL,
    //    productorderdate TIMESTAMPTZ NOT NULL DEFAULT NOW(),
    //    totalcost numeric(10,2) NOT NULL,
    //    nameempresa varchar(40) NOT NULL,
    //    rucempresa varchar(12) NOT NULL,
    //    cantlot integer NOT NULL,
    //    PRIMARY KEY (idproductorder)
    //);
    private Integer idproductorder;
    private String idproductcatalog;
    private Integer idemployee;
    private Float totalcost;
    private String nameempresa;
    private String rucempresa;
    private Integer cantlot;
}
