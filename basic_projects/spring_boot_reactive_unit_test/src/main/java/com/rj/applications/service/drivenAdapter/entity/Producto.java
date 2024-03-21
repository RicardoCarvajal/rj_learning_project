package com.rj.applications.service.drivenAdapter.entity;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.math.BigDecimal;

@Document("productos")
public class Producto {

    private String _id;

    private String codigo;
    private String existencia;

    private String nombre;

    private String descripcion;

    @Field("percio_detal")
    private BigDecimal percioDetal;

    @Field("percio_mayor")
    private BigDecimal percioMayor;

    public Producto() {

    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getExistencia() {
        return existencia;
    }

    public void setExistencia(String existencia) {
        this.existencia = existencia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigDecimal getPercioDetal() {
        return percioDetal;
    }

    public void setPercioDetal(BigDecimal percioDetal) {
        this.percioDetal = percioDetal;
    }

    public BigDecimal getPercioMayor() {
        return percioMayor;
    }

    public void setPercioMayor(BigDecimal percioMayor) {
        this.percioMayor = percioMayor;
    }
}
