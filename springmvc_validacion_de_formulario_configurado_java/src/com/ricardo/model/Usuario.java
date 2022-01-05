package com.ricardo.model;

import javax.persistence.Entity;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotBlank;

@Entity
public class Usuario {

    @NotBlank(message = "El campo usuario no puede estar en blanco")
    private String nombre;

    @Min(value = 5,
         message = "El campo clave debe ser mayor a 5")
    @NotBlank(message = "El campo clave no puede estar en blanco")
    private String clave;

    public Usuario() {

    }

    public Usuario(String nombre, String clave) {
        super();
        this.nombre = nombre;
        this.clave = clave;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

}
