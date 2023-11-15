package com.cibertec.service;

import com.cibertec.entity.Recarga;
import java.util.List;

public interface RecargaService {
  public abstract Recarga registrar(Recarga recarga);

  public abstract void delete(String id);

  public abstract List<Recarga> list();
}
