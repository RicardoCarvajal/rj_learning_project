package com.sofka.service.app.infraestructure.drivenAdapter.entity;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("movimientos")
public class Movimiento {

	@Id
	private String id;

	private String idObjeto;

	private String tipoProceso;

	private String descripcion;

	private Date fecha;

	private Object objeto;

	private Boolean esError;

	private Integer cantidad;

	private String tipoVenta;

	public Movimiento() {

	}

	public String getIdObjeto() {
		return idObjeto;
	}

	public void setIdObjeto(String idObjeto) {
		this.idObjeto = idObjeto;
	}

	public String getTipoProceso() {
		return tipoProceso;
	}

	public void setTipoProceso(String tipoProceso) {
		this.tipoProceso = tipoProceso;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Object getObjeto() {
		return objeto;
	}

	public void setObjeto(Object objeto) {
		this.objeto = objeto;
	}

	public Boolean getEsError() {
		return esError;
	}

	public void setEsError(Boolean esError) {
		this.esError = esError;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public String getTipoVenta() {
		return tipoVenta;
	}

	public void setTipoVenta(String tipoVenta) {
		this.tipoVenta = tipoVenta;
	}

	public static Movimiento building() {
		return new Movimiento();
	}

	public Movimiento idObjeto(String idObjeto) {
		this.idObjeto = idObjeto;
		return this;
	}

	public Movimiento tipoProceso(String tipoProceso) {
		this.tipoProceso = tipoProceso;
		return this;
	}

	public Movimiento descripcion(String descripcion) {
		this.descripcion = descripcion;
		return this;
	}

	public Movimiento fecha(Date fecha) {
		this.fecha = fecha;
		return this;
	}

	public Movimiento objeto(Object objeto) {
		this.objeto = objeto;
		return this;
	}

	public Movimiento esError(Boolean esError) {
		this.esError = esError;
		return this;
	}

	public Movimiento cantidad(Integer cantidad) {
		this.cantidad = cantidad;
		return this;
	}

	public Movimiento tipoVenta(String tipoVenta) {
		this.tipoVenta = tipoVenta;
		return this;
	}

	public Movimiento build() {
		return this;
	}

}
