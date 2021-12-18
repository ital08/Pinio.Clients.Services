package com.pinio.services.Service;

import com.pinio.services.Models.Dao.ProductCatalogDao;
import com.pinio.services.Models.Entity.ProductCatalog;
import com.pinio.services.Models.Entity.SearchProductCatalog;
import com.pinio.services.Models.Entity.Subcategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("ProductsCatalogServiceImpl")
@Transactional
public class ProductsCatalogServiceImpl implements ProductsCatalogService {
    @Autowired
    private ProductCatalogDao dao;
    public SearchProductCatalog getProductCatalog (ProductCatalog productCatalog,String orden,Integer pagNum,Integer pagSize){
        return dao.getProductCatalog(productCatalog,orden,pagNum,pagSize);
    }
    public SearchProductCatalog getProductCatalogSub(Subcategory subcategory, String orden, Integer pagNum, Integer pagSize){
        return dao.getProductCatalogSub(subcategory, orden, pagNum, pagSize);
    }
    public SearchProductCatalog getProductCatalogPrice( String orden, Integer pagNum, Integer pagSize,Integer min,Integer max){
        return dao.getProductCatalogPrice( orden, pagNum, pagSize, min, max);
    }
    public SearchProductCatalog getProductCatalogBrand(ProductCatalog productCatalog, String orden, Integer pagNum, Integer pagSize){
        return dao.getProductCatalogBrand(productCatalog, orden, pagNum, pagSize);
    }

}
