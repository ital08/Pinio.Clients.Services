package com.pinio.services.Service;

import com.pinio.services.Models.Dao.HistoryDao;
import com.pinio.services.Models.Entity.SearchProductCatalog;
import com.pinio.services.Models.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service("HistoryServiceImpl")
public class HistoryServiceImpl implements HistoryService{
    @Autowired
    private HistoryDao dao;
    public SearchProductCatalog getHistorial(User user) {
        return dao.getHistorial(user);
    }
}
