package com.cibertec.entity;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Moves {

    private String name;
    private String mount;
    private String date;

    public Moves() {
    }
}
