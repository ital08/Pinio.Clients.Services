package com.pinio.services.Service;

import com.pinio.services.Models.Entity.User;

public interface RegisterClientService {
    public abstract User registerNewClient(User user);
}
