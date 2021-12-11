package com.pinio.services.Service;

import com.pinio.services.Models.Dao.NewProductDao;
import com.pinio.services.Models.Entity.ProductCatalog;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Transactional
@Service("AddProductServiceImpl")
public class AddProductServiceImpl implements AddProductService{
    @Autowired
    private NewProductDao dao;
    public ProductCatalog addNewProduct(ProductCatalog productcatalog) {
        return dao.addNewProduct(productcatalog);
    }
}
