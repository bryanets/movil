package com.cibertec.service;

import com.cibertec.entity.Recarga;
import com.cibertec.repository.RecargaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecargaServiceImpl implements RecargaService {

  @Autowired
  private RecargaRepository repository;

  @Override
  public Recarga registrar(Recarga recarga) {
    return repository.save(recarga);
  }

  @Override
  public void delete(String id) {
    repository.deleteById(id);
  }

  @Override
  public List<Recarga> list() {
    return repository.findAll();
  }
}
