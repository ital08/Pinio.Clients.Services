package com.pinio.services.Models.Dao;

import com.pinio.services.Models.Entity.SearchProductCatalog;
import com.pinio.services.Models.Entity.ShippingDtaEmp;

public interface ShippingOrderDao {
    public abstract ShippingDtaEmp getShippingOrders(ShippingDtaEmp shippingDtaEmp);
    public abstract SearchProductCatalog getProductOrders(ShippingDtaEmp shippingDtaEmp);
}
