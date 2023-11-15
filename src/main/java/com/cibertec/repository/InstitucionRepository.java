package com.cibertec.repository;

import com.cibertec.entity.Institucion;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface InstitucionRepository
  extends MongoRepository<Institucion, String> {}
