package com.pinio.services.Service;

import com.pinio.services.Models.Entity.ProductOrder;

public interface ProductOrderService {
    //Añadir una orden de producto nueva
    public abstract ProductOrder addProductOrder(ProductOrder productorder);
}
