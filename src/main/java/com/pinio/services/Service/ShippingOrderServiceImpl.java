package com.pinio.services.Service;

import com.pinio.services.Models.Dao.ShippingOrderDao;
import com.pinio.services.Models.Entity.SearchProductCatalog;
import com.pinio.services.Models.Entity.ShippingDtaEmp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("ShippingOrderServiceImpl")
@Transactional
public class ShippingOrderServiceImpl implements ShippingOrderService{

    @Autowired
    private ShippingOrderDao dao;

    public ShippingDtaEmp getShippingOrders(ShippingDtaEmp shippingDtaEmp) {
        return dao.getShippingOrders(shippingDtaEmp);
    }

    public SearchProductCatalog getProductOrders(ShippingDtaEmp shippingDtaEmp) {
        return dao.getProductOrders(shippingDtaEmp);
    }
}
