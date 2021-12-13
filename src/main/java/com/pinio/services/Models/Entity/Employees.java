package com.pinio.services.Models.Entity;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class Employees {
    private Integer idemployee;
    private Integer idjob;
    private String name;
    private String lastname;
    private String createddate;
    private String emailemployee;
    private String password;
}
