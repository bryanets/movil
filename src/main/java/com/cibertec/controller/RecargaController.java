package com.cibertec.controller;

import com.cibertec.entity.Recarga;
import com.cibertec.service.RecargaService;
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
@RequestMapping("/api/recarga")
public class RecargaController {

  @Autowired
  private RecargaService service;

  @GetMapping("/")
  @ResponseBody
  public List<Recarga> list() {
    return service.list();
  }

  @PostMapping("/add")
  @ResponseBody
  public ResponseEntity<Map<String, Object>> insertaRecarga(
    @RequestBody Recarga obj
  ) {
    Map<String, Object> salida = new HashMap<>();
    try {
      Recarga objSalida = service.registrar(obj);
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

  @PutMapping("/updaterecarga")
  @ResponseBody
  public ResponseEntity<Map<String, Object>> actualizaRecarga(
    @RequestBody Recarga obj
  ) {
    Map<String, Object> salida = new HashMap<>();
    try {
      Recarga objSalida = service.registrar(obj);
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

  //http://localhost:8092/api/user/deleteuser?id=654f3f8bb9705724b8f07381
  @DeleteMapping("/deleterecarga")
  @ResponseBody
  public ResponseEntity<Map<String, Object>> eliminaRecarga(
    @RequestParam(name = "id", required = true) String idRecarga
  ) {
    Map<String, Object> salida = new HashMap<>();
    try {
      service.delete(idRecarga);
      salida.put("mensaje", "Usuario eliminado");
    } catch (Exception e) {
      e.printStackTrace();
      salida.put("mensaje", "Error al eliminar usuario");
    }
    return ResponseEntity.ok(salida);
  }
}
