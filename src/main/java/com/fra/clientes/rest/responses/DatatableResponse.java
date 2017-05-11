/**
 * 
 */
package com.fra.clientes.rest.responses;

import java.util.ArrayList;
import java.util.List;

import com.fra.clientes.models.Cliente;

/**
 * Datatable response model
 * 
 * @author renzo.ariel.felitti
 *
 */
public class DatatableResponse {

	private List<Cliente> data = new ArrayList<>();

	public DatatableResponse(){
	}
	
	public DatatableResponse(List<Cliente> data){
		this.data = data;
	}
	
	public List<Cliente> getData() {
		return data;
	}

	public void setData(List<Cliente> data) {
		this.data = data;
	}
}
