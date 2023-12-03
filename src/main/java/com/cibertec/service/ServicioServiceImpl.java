package com.cibertec.service;

import com.cibertec.entity.Servicio;
import com.cibertec.repository.ServicioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicioServiceImpl implements ServicioService {

    @Autowired
    private ServicioRepository repository;

    @Override
    public Servicio registrar(Servicio servicio) {
        try {
            return repository.save(servicio);
        } catch (Exception e) {
            // Aquí puedes manejar la excepción según tus necesidades
            // Por ejemplo, puedes registrar el error, lanzar una excepción personalizada, o devolver un valor por defecto.
            e.printStackTrace(); // Imprimir el stack trace es útil para depurar, pero en producción deberías manejarlo de manera adecuada.
            throw new RuntimeException("Error al registrar el servicio: " + e.getMessage());
        }
    }

    @Override
    public void delete(String id) {
        repository.deleteById(id);
    }

    @Override
    public List<Servicio> list() {
        return repository.findAll();
    }
}
