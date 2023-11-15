package com.cibertec.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Document(collection = "institucioness")
public class Institucion  {
    @Id
    private String id;
    private String name;
}