package com.pinio.services.Models.Entity;

import lombok.Data;

@Data
public class ShippingDtaEmp {
    //Select idshippingorder, idemployee, nombreEmpleado, namedepartment, nameprovincia, namedistrict, shippingstatename
    //from shippingDtaEmp;
    private Integer idshippingorder;
    private Integer idemployee;
    private String nombreEmpleado;
    private String namedepartament;
    private String nameprovincia;
    private String namedistrict;
    private String shippingstatename;
    private Integer idshippingstate;
}
