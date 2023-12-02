package com.cibertec;

import com.cibertec.entity.User;
import com.cibertec.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ProyectoMovilApplicationTests {

    @Autowired
    private UserRepository repo;

    @Test
    void contextLoads() {
        User u = new User();
        u = repo.findByNumCard("12345678901234569");
        System.out.println("***************************");
        System.out.println(u.getName());
    }

}
