package com.cibertec.entity;

import java.util.Map;

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
	private String user;
	private String password;
	private Map<String, Object> movimientos;
}
