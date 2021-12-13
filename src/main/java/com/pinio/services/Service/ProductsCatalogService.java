package com.pinio.services.Service;

import com.pinio.services.Models.Entity.ProductCatalog;
import com.pinio.services.Models.Entity.SearchProductCatalog;

public interface ProductsCatalogService {
    //Traer el catalogo de productos
    public abstract SearchProductCatalog getProductCatalog(ProductCatalog productocatalog,String orden);
}
