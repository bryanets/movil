package com.cibertec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.entity.User;
import com.cibertec.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Override
    public User registrar(User user) {
        return repository.save(user);
    }

    @Override
    public User login(String usu, String pass, String numCard) {
        return repository.login(usu, pass, numCard);
    }

    @Override
    public void delete(String id) {
        repository.deleteById(id);
    }

    @Override
    public List<User> list() {
        return repository.findAll();
    }
}
