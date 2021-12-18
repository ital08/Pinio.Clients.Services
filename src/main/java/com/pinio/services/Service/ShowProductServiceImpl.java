package com.pinio.services.Service;

import com.pinio.services.Models.Dao.ShowProductDao;
import com.pinio.services.Models.Entity.ProductCatalog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("ShowProductServiceImpl")
@Transactional
public class ShowProductServiceImpl implements ShowProductService{
    @Autowired
    private ShowProductDao dao;

    public ProductCatalog showProduct(ProductCatalog productCatalog) {
        return dao.showProduct(productCatalog);
    }
}
