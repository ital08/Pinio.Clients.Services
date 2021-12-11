package com.pinio.services.Models.Entity;

import lombok.Data;

@Data
public class ProductLot {
    //CREATE TABLE productslot (
    //    idproductslot integer NOT NULL,
    //    idproductinventory integer NOT NULL,
    //    productamount integer NOT NULL,
    //    productslotdate TIMESTAMPTZ NOT NULL DEFAULT NOW(),,
    //    PRIMARY KEY (idproductslot)
    //);
    private Integer idproductslot;
    private Integer idproductsInventory;
    private Integer productamount;
}
