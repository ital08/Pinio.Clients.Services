package com.pinio.services.Models.Entity;

import lombok.Data;

import java.sql.Timestamp;
import java.util.Date;

@Data
public class User {
    //    CREATE TABLE client (
//            idclient integer NOT NULL,
//            emailadress integer NOT NULL,
//            dni integer NOT NULL,
//            clientpassword varchar(20) NOT NULL,
//    clientname varchar(50) NOT NULL,
//    clientlastname varchar(50) NOT NULL,
//    email varchar(50) NOT NULL,
//    clientregistrydate TIMESTAMPTZ NOT NULL DEFAULT NOW(),
//    PRIMARY KEY (idclient)
//);nameDistrict, P.nameprovincia, F.nameDepartment
    private Integer idclient;
    private Integer DNI;
    private String clientname;
    private String clientlastname;
    private String clientemail;
    private String clientpassword;
    private Integer emailadress;
    private String nameDistrict;
    private String nameprovincia;
    private String nameDepartment;
    private Timestamp clientregistrydate;
}
