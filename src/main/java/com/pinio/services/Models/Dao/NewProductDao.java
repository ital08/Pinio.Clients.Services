package com.pinio.services.Models.Dao;

import com.pinio.services.Models.Entity.ProductCatalog;

public interface NewProductDao {
    public abstract ProductCatalog addNewProduct(ProductCatalog productcatalog);
}
