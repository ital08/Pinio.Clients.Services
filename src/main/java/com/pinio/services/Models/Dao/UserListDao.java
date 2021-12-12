package com.pinio.services.Models.Dao;

import com.pinio.services.Models.Entity.SearchUsers;
import com.pinio.services.Models.Entity.User;

public interface UserListDao {
    public abstract SearchUsers getUsers(Integer integer);
    public abstract SearchUsers getUsers(User user);
    public abstract SearchUsers getUsers(User user,Integer integer);
}
