package com.pinio.services.Service;

import com.pinio.services.Models.Dao.ProductCatalogDao;
import com.pinio.services.Models.Entity.ProductCatalog;
import com.pinio.services.Models.Entity.SearchProductCatalog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("ProductsCatalogServiceImpl")
@Transactional
public class ProductsCatalogServiceImpl implements ProductsCatalogService {
    @Autowired
    private ProductCatalogDao dao;
    public SearchProductCatalog getProductCatalog (ProductCatalog productcatalog,String orden){
        return dao.getProductCatalog(productcatalog,orden);
    }

}
