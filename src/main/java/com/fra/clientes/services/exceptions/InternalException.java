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
@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Error del servidor")// 500
public class InternalException extends ServiceException {
	
	private static final long serialVersionUID = 1L;

	public InternalException(String msg) {
		super(msg);
	}
}
