package com.pinio.services.Service;

import com.pinio.services.Models.Entity.SearchProductCatalog;
import com.pinio.services.Models.Entity.User;

public interface HistoryService {
    //Creación de vista en la cual se mostrará el historial de los productos
    public abstract SearchProductCatalog getHistorial(User user);
}
