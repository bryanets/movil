package com.cibertec.repository;

import com.cibertec.entity.Servicio;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ServicioRepository extends MongoRepository<Servicio, String> {}
