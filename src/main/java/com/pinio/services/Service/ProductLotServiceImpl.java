package com.pinio.services.Service;

import com.pinio.services.Models.Dao.ProductLotDao;
import com.pinio.services.Models.Entity.ProductLot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service("ProductLotServiceImpl")
public class ProductLotServiceImpl implements ProductLotService {
    @Autowired
    private ProductLotDao dao;
    public ProductLot addProductLot(ProductLot productLot) {
        return dao.addProductLot(productLot);
    }
}
