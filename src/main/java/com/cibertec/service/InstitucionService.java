package com.cibertec.service;

import com.cibertec.entity.Institucion;
import java.util.List;

public interface InstitucionService {
  public abstract Institucion registrar(Institucion intitucion);

  public abstract void delete(String id);

  public abstract List<Institucion> list();
}
