package com.fra.clientes.models;

public class Direccion {

	private int id;
	
	private String direccion;
	
	private String establecimiento;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getEstablecimiento() {
		return establecimiento;
	}

	public void setEstablecimiento(String establecimiento) {
		this.establecimiento = establecimiento;
	}
	
	@Override
	public String toString() {
		return "Direccion: " + this.direccion;
	}
	
	
}
