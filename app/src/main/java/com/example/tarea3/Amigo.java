package com.example.tarea3;

import java.io.Serializable;

public class Amigo implements Serializable {
    public String   nombre;
    public String   hobby;
    public int      edad;
    public int      telefono;
    public String   direccion;

    public Amigo(String nombre, String hobby, int edad, int telefono, String direccion) {
        this.nombre     = nombre;
        this.hobby      = hobby;
        this.edad       = edad;
        this.telefono   = telefono;
        this.direccion  = direccion;
    }

    @Override
    public String toString() {
        return "Amigo{"         +
                  "nombre:'"    + nombre    + '\'' +
                ", hobby:'"     + hobby     + '\'' +
                ", edad:"       + edad      + '\'' +
                ", telefono:"   + telefono  + '\'' +
                ", direccion:'" + direccion +
                    '}';
    }
}
