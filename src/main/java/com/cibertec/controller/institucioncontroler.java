package com.cibertec.controller;

import com.cibertec.entity.Institucion;
import com.cibertec.service.InstitucionService;
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
@RequestMapping("/api/institucion")
public class institucioncontroler {

  @Autowired
  private InstitucionService service;

  @GetMapping("/")
  @ResponseBody
  public List<Institucion> list() {
    List<Institucion> obj = service.list();
    return obj;
  }

  @PostMapping("/add")
  @ResponseBody
  public ResponseEntity<Map<String, Object>> insertaInstitucio(
    @RequestBody Institucion obj
  ) {
    Map<String, Object> salida = new HashMap<>();
    try {
      Institucion objSalida = service.registrar(obj);
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

  @PutMapping("/updateinstitucion")
  @ResponseBody
  public ResponseEntity<Map<String, Object>> actualizaIntitucion(
    @RequestBody Institucion obj
  ) {
    Map<String, Object> salida = new HashMap<>();
    try {
      Institucion objSalida = service.registrar(obj);
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
  @DeleteMapping("/deleteinstitucion")
  @ResponseBody
  public ResponseEntity<Map<String, Object>> eliminaIntitucion(
    @RequestParam(name = "id", required = true) String idIntitucion
  ) {
    Map<String, Object> salida = new HashMap<>();
    try {
      service.delete(idIntitucion);
      salida.put("mensaje", "Usuario eliminado");
    } catch (Exception e) {
      e.printStackTrace();
      salida.put("mensaje", "Error al eliminar usuario");
    }
    return ResponseEntity.ok(salida);
  }
}
