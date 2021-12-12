package com.pinio.services.Service;

import com.pinio.services.Models.Entity.SearchSelsReg;
import com.pinio.services.Models.Entity.SelsReg;

public interface ReporteriaService {
    //Todas las funciones de reporteria
    public abstract SearchSelsReg getVentasDistrito();
    public abstract SearchSelsReg getVentasProvincia();
    public abstract SearchSelsReg getVentasDepartamento();
    public abstract Integer getUsuariosNuevos();
    public abstract Integer getUsuariosTotales();
    public abstract SearchSelsReg getVentasDiariasMesActual();
    public abstract SearchSelsReg getVentasDiariasMes(Integer integer);
    public abstract SelsReg getVentadelDia();
    public abstract SearchSelsReg getVentasMendualesAnioActual();
    public abstract SearchSelsReg getVentasMendualesAnio(Integer integer);
}
