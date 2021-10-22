package com.pinio.services.Models.Dao;

import com.pinio.services.Models.Entity.ProductCatalog;
import com.pinio.services.Models.Entity.SearchProductCatalog;

public interface ProductCatalogDao {
    public abstract SearchProductCatalog getProductCatalog(ProductCatalog productcatalog);

}
