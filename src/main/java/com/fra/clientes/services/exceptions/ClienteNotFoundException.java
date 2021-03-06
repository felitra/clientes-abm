/**
 * 
 */
package com.fra.clientes.services.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author renzo.ariel.felitti
 *
 */
@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="Cliente no existente") //404
public class ClienteNotFoundException extends ServiceException{

	private static final long serialVersionUID = 1L;

	public ClienteNotFoundException(String msg){
		super(msg);
	}
}
