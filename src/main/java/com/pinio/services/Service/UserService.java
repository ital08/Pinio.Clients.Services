package com.pinio.services.Service;

import com.pinio.services.Models.Entity.LoginUser;
import com.pinio.services.Models.Entity.User;

public interface UserService {
    //login Usuario
    public abstract User login (LoginUser loginuser);
}
