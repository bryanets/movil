package com.cibertec.service;

import java.util.List;

import com.cibertec.entity.User;

public interface UserService {
	public abstract User registrar(User user);

	public abstract User login(String usu, String pass);

	public abstract void delete(String id);

	public abstract List<User> list();
}
