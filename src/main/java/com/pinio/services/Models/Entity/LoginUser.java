package com.pinio.services.Models.Entity;

import lombok.Data;

@Data
public class LoginUser {

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
//);
    private String clientemail;
    private String clientpassword;
}
