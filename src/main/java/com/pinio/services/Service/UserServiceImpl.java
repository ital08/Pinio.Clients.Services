package com.pinio.services.Service;

import com.pinio.services.Models.Dao.UserServiceDao;
import com.pinio.services.Models.Entity.LoginUser;
import com.pinio.services.Models.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("UserServiceImpl")
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserServiceDao dao;
    public User login (LoginUser loginuser){
        return dao.login(loginuser);
    }
}
