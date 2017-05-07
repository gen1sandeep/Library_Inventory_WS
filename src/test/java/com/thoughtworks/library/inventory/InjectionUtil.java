package com.thoughtworks.library.inventory;

import org.skife.jdbi.v2.DBI;

import com.thoughtworks.library.inventory.dbaccess.BookAvailabilityDAO;
import com.thoughtworks.library.inventory.dbaccess.ProcurementDAO;
import com.thoughtworks.library.inventory.service.BookAvailabilitySearchService;
import com.thoughtworks.library.inventory.service.BookAvailabilitySearchServiceImpl;
import com.thoughtworks.library.inventory.service.ProcurementService;
import com.thoughtworks.library.inventory.service.ProcurementServiceImpl;

// this is to be replaced with mock
public class InjectionUtil {

	
	DBI dbi;
	
	public InjectionUtil() {
		// temporary : to be replaced by mocking library
				try {
					Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
				} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
					e.printStackTrace();
				}
				String url = "jdbc:derby://localhost:1527/inventorydb;user=admin;password=P@ssw0rd";
				dbi = new DBI(url);				
	}

	public BookAvailabilityDAO getBookingAvailabiltyDAO() {
		return dbi.onDemand(BookAvailabilityDAO.class);
	}
	public ProcurementDAO getProcurementDAO() {
		return dbi.onDemand(ProcurementDAO.class);
	}
	public BookAvailabilitySearchService getBookingSerachService() {		
		return new BookAvailabilitySearchServiceImpl(getBookingAvailabiltyDAO());
	}
	
	public ProcurementService getProcurementService() {		
		return new ProcurementServiceImpl(getProcurementDAO());
	}
	
	
}
