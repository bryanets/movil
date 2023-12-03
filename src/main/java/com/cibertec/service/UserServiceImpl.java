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
        
        if (repository.findByNumCard(user.getNumCard()) == null || repository.findByDni(user.getDni()) == null) {
            user = null;
        } else {
            user = repository.save(user);
        }
        
        return user;
    }
    
    @Override
    public User login(String dni, String pass, String numCard) {
        return repository.login(dni, pass, numCard);
    }
    
    @Override
    public void delete(String id) {
        repository.deleteById(id);
    }
    
    @Override
    public List<User> list() {
        return repository.findAll();
    }
    
    @Override
    public User update(User user) {
        return repository.save(user); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
