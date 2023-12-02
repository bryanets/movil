package com.cibertec.entity;

import java.util.Map;
import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Bryan
 */
@Getter
@Setter
@Document(collection = "user")
public class User {

    @Id
    private String id;
    private String name;
    private String dni;
    private String numCard;
    private String user;
    private String password;
    private Double saldo;
    private List<Moves> moves;
}
