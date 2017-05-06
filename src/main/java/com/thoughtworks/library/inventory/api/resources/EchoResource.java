package com.thoughtworks.library.inventory.api.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/echo")
public class EchoResource {

	
	@GET	
	public Response doEcho() {
		return Response.ok().status(200).build();
	}
	
	
	
}
