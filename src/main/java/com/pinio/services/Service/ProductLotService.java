package com.pinio.services.Service;

import com.pinio.services.Models.Entity.ProductLot;

public interface ProductLotService {
    //añadir un nuevo lote
    public abstract ProductLot addProductLot(ProductLot productLot);
}
