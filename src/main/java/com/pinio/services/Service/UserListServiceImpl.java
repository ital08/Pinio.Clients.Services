package com.pinio.services.Service;

import com.pinio.services.Models.Dao.UserListDao;
import com.pinio.services.Models.Entity.SearchUsers;
import com.pinio.services.Models.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("UserListServiceImpl")
@Transactional

public class UserListServiceImpl implements UserListService{
    @Autowired
    private UserListDao dao;
    public SearchUsers getUsers(Integer integer) {
        return dao.getUsers(integer);
    }
    public SearchUsers getUsers(User user,Integer integer) {
        return dao.getUsers(user,integer);
    }
    public SearchUsers getUsers(User user) {
        return dao.getUsers(user);
    }
}
