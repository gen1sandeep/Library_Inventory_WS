package com.thoughtworks.library.inventory.api.resources;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.thoughtworks.library.inventory.model.BookInventoryInfo;
import com.thoughtworks.library.inventory.service.BookAvailabilitySearchService;

 

@Path("/books") 
@Consumes(MediaType.APPLICATION_JSON) 
@Produces(MediaType.APPLICATION_JSON) 
public class BookSearchResource { 
 
	 final static Logger logger = LoggerFactory.getLogger(BookSearchResource.class); 
	private BookAvailabilitySearchService serviceImpl;
	
	@Inject
	public BookSearchResource(BookAvailabilitySearchService serviceImpl) {
		this.serviceImpl=serviceImpl;
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)	
	public BookInventoryInfo getUsers(@QueryParam("isbn") String ISBN){
		BookInventoryInfo info=null;
		try {
			info = serviceImpl.getInventoryDetails(ISBN);
		} catch (Exception e) {
			logger.error("Error while fetching book information.",e);
			// throwing down further to handle exception and send relevant response to client
			throw e;
		}
		return info;
	}
}
	