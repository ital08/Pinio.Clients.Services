package com.pinio.services.Service;

import com.pinio.services.Models.Dao.ProductCatalogDao;
import com.pinio.services.Models.Dao.RegisterClientDao;
import com.pinio.services.Models.Dao.RegisterClientDaoImpl;
import com.pinio.services.Models.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("RegisterClientServiceImpl")
@Transactional
public class RegisterClientServiceImpl implements RegisterClientService{
    @Autowired
    private RegisterClientDao dao;
    public User registerNewClient(User user){
        return dao.registerNewClient(user);
    }
}
