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
    return repository.save(servicio);
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
