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
@ResponseStatus(value=HttpStatus.BAD_REQUEST, reason="Bad request") //400
public class BadRequestException extends ServiceException {

	private static final long serialVersionUID = 1L;

	public BadRequestException(String msg) {
		super(msg);
	}

}
