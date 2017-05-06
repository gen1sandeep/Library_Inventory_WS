package com.thoughtworks.library.inventory.common.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class IncorrectRequestExceptionMapper implements ExceptionMapper<IncorrectRequestDataException> {

	@Override
	public Response toResponse(IncorrectRequestDataException ex) {		
		return Response.status(Status.BAD_REQUEST)
				.entity(ex.getMessage())
				.build();
	}

}
