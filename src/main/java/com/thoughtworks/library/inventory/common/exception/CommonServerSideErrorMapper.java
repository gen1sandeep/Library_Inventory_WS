package com.thoughtworks.library.inventory.common.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.thoughtworks.library.inventory.model.GenericErrorInfo;



 @Provider
public class CommonServerSideErrorMapper implements ExceptionMapper<Exception> {

	@Override
	public Response toResponse(Exception ex) {		
		GenericErrorInfo errorMessage = new GenericErrorInfo();
		errorMessage.setErrorMessage(ex.getMessage());
		return Response.status(Status.INTERNAL_SERVER_ERROR)
				.entity(errorMessage)
				.build();
	}	
}