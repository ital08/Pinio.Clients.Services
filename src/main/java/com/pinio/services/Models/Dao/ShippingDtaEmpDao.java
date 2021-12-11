package com.pinio.services.Models.Dao;

import com.pinio.services.Models.Entity.SearchShippingDtaEmp;
import com.pinio.services.Models.Entity.ShippingDtaEmp;

public interface ShippingDtaEmpDao {
    public abstract SearchShippingDtaEmp getShippingDtaEmp();
    public abstract ShippingDtaEmp chageShippingState(ShippingDtaEmp shippingDtaEmp);
}
