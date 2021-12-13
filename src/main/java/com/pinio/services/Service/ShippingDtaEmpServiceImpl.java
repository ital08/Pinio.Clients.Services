package com.pinio.services.Service;

import com.pinio.services.Models.Dao.ShippingDtaEmpDao;
import com.pinio.services.Models.Entity.SearchShippingDtaEmp;
import com.pinio.services.Models.Entity.ShippingDtaEmp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("ShippingDtaEmpServiceImpl")
@Transactional
public class ShippingDtaEmpServiceImpl implements ShippingDtaEmpService{
    @Autowired
    private ShippingDtaEmpDao dao;

    public SearchShippingDtaEmp getShippingDtaEmp() {
        return dao.getShippingDtaEmp();
    }

    public ShippingDtaEmp changeShippingState(ShippingDtaEmp shippingDtaEmp) {
        return dao.changeShippingState(shippingDtaEmp);
    }
}
