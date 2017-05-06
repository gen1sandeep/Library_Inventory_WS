package com.thoughtworks.library.inventory;

import org.skife.jdbi.v2.DBI;

import com.thoughtworks.library.inventory.dbaccess.BookAvailabilityDAO;
import com.thoughtworks.library.inventory.service.BookAvailabilitySearchService;
import com.thoughtworks.library.inventory.service.BookAvailabilitySearchServiceImpl;

// this is to be replaced with mock
public class InjectionUtil {

	
	private BookAvailabilityDAO dao;

	private void initialize() {
		// temporary : to be replaced by mocking library
		try {
			Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		String url = "jdbc:derby://localhost:1527/inventorydb;user=admin;password=P@ssw0rd";
		DBI dbi = new DBI(url);
		dao = dbi.onDemand(BookAvailabilityDAO.class);
		
	}

	public BookAvailabilityDAO getBookingAvailabiltyDAO() {
		initialize();
		return dao;
	}
	public BookAvailabilitySearchService getBookingSerachService() {
		initialize();
		return new BookAvailabilitySearchServiceImpl(dao);
	}
}
