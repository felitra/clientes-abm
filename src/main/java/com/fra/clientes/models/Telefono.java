/**
 * 
 */
package com.fra.clientes.models;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author renzo.ariel.felitti
 *
 */
public class Telefono {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private long numero;

	public Telefono() {
	}
	
	public Telefono(long numero) {
		this.numero = numero;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getNumero() {
		return numero;
	}

	public void setNumero(long numero) {
		this.numero = numero;
	}

}
