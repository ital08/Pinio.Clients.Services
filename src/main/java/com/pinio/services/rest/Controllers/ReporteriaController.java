package com.pinio.services.rest.Controllers;

import com.pinio.services.Models.Entity.SearchSelsReg;
import com.pinio.services.Models.Entity.SelsReg;
import com.pinio.services.Service.ReporteriaService;
import org.springframework.beans.factory.annotation.Autowired;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*",methods = {RequestMethod.POST,RequestMethod.GET})
@RequestMapping("/reportery")
public class ReporteriaController {
    @Autowired
    private ReporteriaService service;

    @RequestMapping(
            value = "/getVentasDepartamento",
            produces = "application/json;charset=utf-8",
            method = RequestMethod.GET
    )
    public @ResponseBody
    SearchSelsReg getVentasDepartamento(){
        return service.getVentasDepartamento();
    }
    @RequestMapping(
            value = "/getVentasDistrito",
            produces = "application/json;charset=utf-8",
            method = RequestMethod.GET
    )
    public @ResponseBody
    SearchSelsReg getVentasDistrito(){
        return service.getVentasDistrito();
    }
    @RequestMapping(
            value = "/getVentasProvincia",
            produces = "application/json;charset=utf-8",
            method = RequestMethod.GET
    )
    public @ResponseBody
    SearchSelsReg getVentasProvincia(){
        return service.getVentasProvincia();
    }
    @RequestMapping(
            value = "/getVentasDiariasMesActual",
            produces = "application/json;charset=utf-8",
            method = RequestMethod.GET
    )
    public @ResponseBody
    SearchSelsReg getVentasDiariasMesActual(){
        return service.getVentasDiariasMesActual();
    }
    @RequestMapping(
            value = "/getVentasDiariasMes",
            produces = "application/json;charset=utf-8",
            method = RequestMethod.GET
    )
    public @ResponseBody
    SearchSelsReg getVentasDiariasMes(@RequestBody Integer integer){
        return service.getVentasDiariasMes(integer);
    }
    @RequestMapping(
            value = "/getUsuariosNuevos",
            produces = "application/json;charset=utf-8",
            method = RequestMethod.GET
    )
    public @ResponseBody
    Integer getUsuariosNuevos(){
        return service.getUsuariosNuevos();
    }
    @RequestMapping(
            value = "/getUsuariosTotales",
            produces = "application/json;charset=utf-8",
            method = RequestMethod.GET
    )
    public @ResponseBody
    Integer getUsuariosTotales(){
        return service.getUsuariosTotales();
    }
    @RequestMapping(
            value = "/getVentadelDia",
            produces = "application/json;charset=utf-8",
            method = RequestMethod.GET
    )
    public @ResponseBody
    SelsReg getVentadelDia(){
        return service.getVentadelDia();
    }
    @RequestMapping(
            value = "/getVentasMendualesAnioActual",
            produces = "application/json;charset=utf-8",
            method = RequestMethod.GET
    )
    public @ResponseBody
    SearchSelsReg getVentasMendualesAnioActual(){
        return service.getVentasMendualesAnioActual();
    }
    @RequestMapping(
            value = "/getVentasMendualesAnio",
            produces = "application/json;charset=utf-8",
            method = RequestMethod.GET
    )
    public @ResponseBody
    SearchSelsReg getVentasMendualesAnio(@RequestBody Integer integer){
        return service.getVentasMendualesAnio(integer);
    }
}
