package com.pinio.services.Models.Dao;

import com.pinio.services.Models.Entity.ProductCatalog;

public interface ShowProductDao {
    public abstract ProductCatalog showProduct(ProductCatalog productCatalog);
}
