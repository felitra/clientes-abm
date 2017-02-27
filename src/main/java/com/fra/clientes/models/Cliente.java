package com.fra.clientes.models;

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
	
	private String telefono;

	private String direccion;

	private String establecimiento;
	
	public Cliente (){
		
	}
	
	public Cliente(String nombreApellido, String telefono, String direccion, String establecimiento){
		this.nombreApellido=nombreApellido;
		this.telefono=telefono;
		this.direccion=direccion;
		this.establecimiento=establecimiento;
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
		return String.format("Cliente: %s con telefono: %s y direccion: %s", nombreApellido, telefono, direccion);
	}

}
