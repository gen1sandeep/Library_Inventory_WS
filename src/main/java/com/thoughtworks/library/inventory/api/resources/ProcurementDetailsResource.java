package com.thoughtworks.library.inventory.api.resources;
import java.net.URI;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.Response.StatusType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.thoughtworks.library.inventory.common.exception.DataNotFoundException;
import com.thoughtworks.library.inventory.model.BookProcurementInfo;
import com.thoughtworks.library.inventory.service.ProcurementService;
import com.thoughtworks.library.inventory.service.ProcurementServiceImpl;

 
/**
 * Resource for Registering Procurement and to provide details
 * @author Sandeep_Alla
 *
 */

@Path("/ProcurementDetails")
@Produces(MediaType.APPLICATION_JSON) 
public class ProcurementDetailsResource { 
 
	 final static Logger logger = LoggerFactory.getLogger(ProcurementDetailsResource.class); 
	private ProcurementService serviceImpl;
	
	@Inject
	public ProcurementDetailsResource(ProcurementServiceImpl serviceImpl) {
		this.serviceImpl=serviceImpl;
	}


	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addMessage(BookProcurementInfo inputVO, @Context UriInfo uriInfo) {
		
		long bookId = serviceImpl.procureBook(inputVO);		
		inputVO.setBookId(bookId);
		URI uri = uriInfo.getAbsolutePathBuilder().path(Long.toString(bookId)).build();
		return Response.created(uri)
				.entity(inputVO)
				.status(Status.OK)
				.build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)	
	public BookProcurementInfo getProcurementDetails(@QueryParam("bookId") long bookId){		
		BookProcurementInfo info=null;
		try {
			info = serviceImpl.getProcurementDetails(bookId);
		} catch (DataNotFoundException e) {
			logger.error("Error while fetching book information.",e);
			// throwing down further to handle exception and send relevant response to client
			throw e;
		}
		return info;
	}
}
	