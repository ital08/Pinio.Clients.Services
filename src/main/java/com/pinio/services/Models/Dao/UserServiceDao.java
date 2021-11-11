package com.pinio.services.Models.Dao;

import com.pinio.services.Models.Entity.LoginUser;
import com.pinio.services.Models.Entity.User;
import org.springframework.context.annotation.Bean;

public interface UserServiceDao {
    public abstract User login (LoginUser loginuser);
}
