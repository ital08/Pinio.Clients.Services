package com.pinio.services.Service;

import com.pinio.services.Models.Dao.ReporteriaDao;
import com.pinio.services.Models.Entity.SearchSelsReg;
import com.pinio.services.Models.Entity.SelsReg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("ReporteriaServiceImpl")
@Transactional
public class ReporteriaServiceImpl implements ReporteriaService{
    @Autowired
    private ReporteriaDao dao;
    public SearchSelsReg getVentasDistrito() {
        return dao.getVentasDistrito();
    }

    public SearchSelsReg getVentasProvincia() {
        return dao.getVentasProvincia();
    }

    public SearchSelsReg getVentasDepartamento() {
        return dao.getVentasDepartamento();
    }

    public Integer getUsuariosNuevos() {
        return dao.getUsuariosNuevos();
    }

    public Integer getUsuariosTotales() {
        return dao.getUsuariosTotales();
    }

    public SearchSelsReg getVentasDiariasMesActual() {
        return dao.getVentasDiariasMesActual();
    }

    public SearchSelsReg getVentasDiariasMes(Integer integer) {
        return dao.getVentasDiariasMes(integer);
    }

    public SelsReg getVentadelDia() {
        return dao.getVentadelDia();
    }

    public SearchSelsReg getVentasMendualesAnioActual() {
        return dao.getVentasMendualesAnioActual();
    }

    public SearchSelsReg getVentasMendualesAnio(Integer integer) {
        return dao.getVentasMendualesAnio(integer);
    }
}
