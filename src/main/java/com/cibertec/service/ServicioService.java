package com.cibertec.service;

import com.cibertec.entity.Servicio;
import java.util.List;

public interface ServicioService {
  public abstract Servicio registrar(Servicio servicio);

  public abstract void delete(String id);

  public abstract List<Servicio> list();
}
