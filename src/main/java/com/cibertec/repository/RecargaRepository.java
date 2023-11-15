package com.cibertec.repository;

import com.cibertec.entity.Recarga;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RecargaRepository extends MongoRepository<Recarga, String> {}
