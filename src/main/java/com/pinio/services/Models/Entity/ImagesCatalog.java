package com.pinio.services.Models.Entity;


import lombok.Data;

@Data

public class ImagesCatalog {
//    CREATE TABLE public.imagescatalog (
//            idimagescatalog varchar(9) NOT NULL,
//    idproductcatalog varchar(10) NOT NULL,
//    urlimage varchar(150) NOT NULL,
//    position integer NOT NULL,
//    PRIMARY KEY (idimagescatalog)
//);
    private Integer idImagesCatalog;
    private String idProductCatalog;
    private String urlimage;
    private Integer position;
}
