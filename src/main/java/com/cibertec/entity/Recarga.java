package com.cibertec.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "recarga")
public class Recarga {

  @Id
  private String id;

  private String operador;
}
