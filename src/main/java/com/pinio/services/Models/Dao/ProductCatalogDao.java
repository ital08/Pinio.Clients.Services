package com.pinio.services.Models.Dao;

import com.pinio.services.Models.Entity.ProductCatalog;
import com.pinio.services.Models.Entity.SearchProductCatalog;
import com.pinio.services.Models.Entity.Subcategory;

public interface ProductCatalogDao {
    public abstract SearchProductCatalog getProductCatalog(ProductCatalog productCatalog,String orden,Integer pagNum,Integer pagSize);
    public abstract SearchProductCatalog getProductCatalogSub(Subcategory subcategory, String orden, Integer pagNum, Integer pagSize);
    public abstract SearchProductCatalog getProductCatalogPrice( String orden, Integer pagNum, Integer pagSize,Integer min,Integer max);
    public abstract SearchProductCatalog getProductCatalogBrand(ProductCatalog productCatalog, String orden, Integer pagNum, Integer pagSize);

}
