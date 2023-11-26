package com.cibertec.controller;

import com.cibertec.entity.User;
import com.cibertec.service.UserService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping("/")
    public ResponseEntity<List<User>> list() {
        List<User> list = service.list();
        return ResponseEntity.ok(list);
    }

    @PostMapping("/login")
    @ResponseBody
    public ResponseEntity<User> login(@RequestBody User obj) {
        obj = service.login(obj.getUser(), obj.getPassword());
        return ResponseEntity.ok(obj);
    }

    @PostMapping("/signup")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> insertaUser(@RequestBody User obj) {
        Map<String, Object> salida = new HashMap<>();
        try {
            User objSalida = service.registrar(obj);
            if (objSalida == null) {
                salida.put("mensaje", "Error en el registro");
            } else {
                salida.put("mensaje", "Registrado correctamente");
            }
        } catch (Exception e) {
            e.printStackTrace();
            salida.put("mensaje", "Error en el registro");
        }
        return ResponseEntity.ok(salida);
    }

    @PutMapping("/updateuser")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> actualizaUser(@RequestBody User obj) {
        Map<String, Object> salida = new HashMap<>();
        try {
            User objSalida = service.registrar(obj);
            if (objSalida == null) {
                salida.put("mensaje", "Error en la actualización");
            } else {
                salida.put("mensaje", "Actualización correcta");
            }
        } catch (Exception e) {
            e.printStackTrace();
            salida.put("mensaje", "Error en la actualización");
        }
        return ResponseEntity.ok(salida);
    }

    // http://localhost:8092/api/user/deleteuser?id=654f3f8bb9705724b8f07381
    @DeleteMapping("/deleteuser")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> eliminaUser(
            @RequestParam(name = "id", required = true) String idUser
    ) {
        Map<String, Object> salida = new HashMap<>();
        try {
            service.delete(idUser);
            salida.put("mensaje", "Usuario eliminado");
        } catch (Exception e) {
            e.printStackTrace();
            salida.put("mensaje", "Error al eliminar usuario");
        }
        return ResponseEntity.ok(salida);
    }
}
