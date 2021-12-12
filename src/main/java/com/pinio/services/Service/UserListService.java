package com.pinio.services.Service;

import com.pinio.services.Models.Entity.SearchUsers;
import com.pinio.services.Models.Entity.User;

public interface UserListService {
    //Listado de usuarios y busqueda de usuarios por id y nombre
    public abstract SearchUsers getUsers(Integer integer);
    public abstract SearchUsers getUsers(User user, Integer integer);
    public abstract SearchUsers getUsers(User user);
}
