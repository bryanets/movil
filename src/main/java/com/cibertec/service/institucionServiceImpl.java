package com.cibertec.service;

import com.cibertec.entity.Institucion;
import com.cibertec.repository.InstitucionRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class institucionServiceImpl implements InstitucionService {

  @Autowired
  private InstitucionRepository repository;

  @Override
  public Institucion registrar(Institucion intitucion) {
    return repository.save(intitucion);
  }

  @Override
  public void delete(String id) {
    repository.deleteById(id);
  }

  @Override
  public List<Institucion> list() {
    return repository.findAll();
  }
}
