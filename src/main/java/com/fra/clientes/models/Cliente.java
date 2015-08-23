package com.fra.clientes.models;

public class Cliente {

	private int id;

	private String nombreApellido;

	private String telefono;

	private String direccion;

	private String establecimiento;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombreApellido() {
		return nombreApellido;
	}

	public void setNombreApellido(String nombreApellido) {
		this.nombreApellido = nombreApellido;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
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
		return "Cliente: " + this.nombreApellido + " con telefono: "
				+ this.telefono + " y direccion: " + this.direccion;
	}

}
