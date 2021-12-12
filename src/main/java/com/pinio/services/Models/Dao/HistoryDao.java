package com.pinio.services.Models.Dao;

import com.pinio.services.Models.Entity.SearchProductCatalog;
import com.pinio.services.Models.Entity.User;

public interface HistoryDao {
    public abstract SearchProductCatalog getHistorial(User user);
}
