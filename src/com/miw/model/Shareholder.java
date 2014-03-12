package com.miw.model;

public class Shareholder {

	private int id;
	private String idProyecto;
	private String idAccionario;
	private Double dinero;
	private boolean pendiente;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIdProyecto() {
		return idProyecto;
	}

	public void setIdProyecto(String idProyecto) {
		this.idProyecto = idProyecto;
	}

	public String getIdAccionario() {
		return idAccionario;
	}

	public void setIdAccionario(String idAccionario) {
		this.idAccionario = idAccionario;
	}

	public Double getDinero() {
		return dinero;
	}

	public void setDinero(Double dinero) {
		this.dinero = dinero;
	}

	public boolean isPendiente() {
		return pendiente;
	}

	public void setPendiente(boolean pendiente) {
		this.pendiente = pendiente;
	}
}
