package com.pinio.services.Service;

import com.pinio.services.Models.Entity.ProductCatalog;

public interface AddProductService {
    //Añadir un nuevo producto a el catalogo
    public abstract ProductCatalog addNewProduct(ProductCatalog productCatalog);
}
