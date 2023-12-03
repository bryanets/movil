package com.cibertec.controller;

import com.cibertec.entity.Servicio;
import com.cibertec.service.ServicioService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
@RequestMapping("/api/servicio")
public class ServiceController {

    @Autowired
    private ServicioService service;

    @GetMapping("/")
    @ResponseBody
    public List<Servicio> list() {
        return service.list();
    }

    @GetMapping("/lista")
    public ResponseEntity<Map<String, String>> lista() {
        System.out.println("esto esta funcionando desde servicio");
        return new ResponseEntity<>(
                Map.of("message", "Hello my friend from servicio!"),
                HttpStatus.OK
        );
    }

    @PostMapping("/add")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> insertaUser(
            @RequestBody Servicio obj
    ) {
        Map<String, Object> salida = new HashMap<>();
        try {
            Servicio objSalida = service.registrar(obj);
            if (objSalida == null) {
                salida.put("mensaje", "Error en el registro");
            } else {
                salida.put("mensaje", "Registrado correctamente");
            }
        } catch (Exception e) {
            e.printStackTrace();
            salida.put("mensaje", "Ocurrió un error");
        }
        return ResponseEntity.ok(salida);
    }

    @PutMapping("/updateservicio")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> actualizaUser(@RequestBody Servicio obj) {
        Map<String, Object> salida = new HashMap<>();
        try {
            Servicio objSalida = service.registrar(obj);
            if (objSalida == null) {
                salida.put("mensaje", "Error en la actualización");
            } else {
                salida.put("mensaje", "Actualización correcta");
            }
        } catch (Exception e) {
            e.printStackTrace();
            salida.put("mensaje", "Ocurrió un error");
        }
        return ResponseEntity.ok(salida);
    }

    //http://localhost:8080/api/user/deleteservicio?id=654f3f8bb9705724b8f07381
    @DeleteMapping("/deleteservicio")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> eliminaUser(
            @RequestParam(name = "id", required = true) String idServicio
    ) {
        Map<String, Object> salida = new HashMap<>();
        try {
            service.delete(idServicio);
            salida.put("mensaje", "Servicio eliminado");
        } catch (Exception e) {
            e.printStackTrace();
            salida.put("mensaje", "Ocurrió un error");
        }
        return ResponseEntity.ok(salida);
    }
}
