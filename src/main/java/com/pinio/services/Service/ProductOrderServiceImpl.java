package com.pinio.services.Service;

import com.pinio.services.Models.Dao.ProductOrderDao;
import com.pinio.services.Models.Entity.ProductOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service("ProductOrderServiceImpl")
public class ProductOrderServiceImpl implements ProductOrderService{
    @Autowired
    private ProductOrderDao dao;
    public ProductOrder addProductOrder(ProductOrder productorder) {
        return dao.addProductOrder(productorder);
    }
}
