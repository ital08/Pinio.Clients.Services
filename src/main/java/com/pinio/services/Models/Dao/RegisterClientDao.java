package com.pinio.services.Models.Dao;

import com.pinio.services.Models.Entity.User;



public interface RegisterClientDao {

    public abstract User registerNewClient(User user);
}
