package com.fra.clientes.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String nombreApellido;

	private List<Telefono> telefonos;

	private String direccion;

	private String establecimiento;

	public Cliente() {

	}

	public Cliente(String nombreApellido, List<Telefono> telefonos, String direccion, String establecimiento) {
		this.nombreApellido = nombreApellido;
		this.telefonos = telefonos;
		this.direccion = direccion;
		this.establecimiento = establecimiento;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombreApellido() {
		return nombreApellido;
	}

	public void setNombreApellido(String nombreApellido) {
		this.nombreApellido = nombreApellido;
	}

	public List<Telefono> getTelefonos() {
		return telefonos;
	}

	public void setTelefonos(List<Telefono> telefonos) {
		this.telefonos = telefonos;
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
		return String.format("Cliente: %s con telefonos: %s y direccion: %s", nombreApellido, telefonos, direccion);
	}

}
