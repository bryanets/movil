package com.cibertec.service;

import java.util.List;

import com.cibertec.entity.User;

public interface UserService {

    public abstract User registrar(User user);

    public abstract User login(String dni, String pass, String numCard);

    public abstract void delete(String id);

    public abstract List<User> list();

    public abstract User update(User user);
}
