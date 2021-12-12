package com.pinio.services.Service;

import com.pinio.services.Models.Entity.ProductCatalog;
import com.pinio.services.Models.Entity.SearchProductCatalog;
import com.pinio.services.Models.Entity.SearchShippingDtaEmp;
import com.pinio.services.Models.Entity.ShippingDtaEmp;

public interface ShippingOrderService {
    //Vista de creación para mostrar datos del empleado y del envió
    public abstract ShippingDtaEmp getShippingOrders(ShippingDtaEmp shippingDtaEmp);
    public abstract SearchProductCatalog getProductOrders(ShippingDtaEmp shippingDtaEmp);
}
