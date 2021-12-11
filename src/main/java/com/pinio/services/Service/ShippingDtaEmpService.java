package com.pinio.services.Service;

import com.pinio.services.Models.Entity.SearchShippingDtaEmp;
import com.pinio.services.Models.Entity.ShippingDtaEmp;

public interface ShippingDtaEmpService {
    //Traer Lista de Envios, cambiar el estado de envio
    public abstract SearchShippingDtaEmp getShippingDtaEmp();
    public abstract ShippingDtaEmp chageShippingState(ShippingDtaEmp shippingDtaEmp);
}
