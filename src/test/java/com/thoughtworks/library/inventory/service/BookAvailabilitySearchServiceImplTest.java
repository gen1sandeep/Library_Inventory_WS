package com.thoughtworks.library.inventory.service;

import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;
import org.skife.jdbi.v2.DBI;

import com.thoughtworks.library.inventory.dbaccess.BookAvailabilityDAO;
import com.thoughtworks.library.inventory.model.BookAvailabilityInfo;

public class BookAvailabilitySearchServiceImplTest {

	private BookAvailabilitySearchService service;
	@Before
	public void setup(){
		try {
			Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		String url = "jdbc:derby://localhost:1527/inventorydb;user=admin;password=P@ssw0rd";
		DBI dbi = new DBI(url);
		BookAvailabilityDAO dao = dbi.onDemand(BookAvailabilityDAO.class);
		service = new BookAvailabilitySearchServiceImpl(dao);
		};
	
	
	@Test
	public final void testBookAvailabilitySearchServiceImpl() {
		String input = "978-3-16-148412-0";
		BookAvailabilityInfo result = service.getInventoryDetails(input);
		if(result == null){			
			fail ("Exepected valid result, but received null response");
		}else{
			assert(result.getISBN().equalsIgnoreCase(input));
			}
		}
	
	@Test(/*expected=Exception.class*/)
	public final void testBookAvailabilitySearchServiceImplforFailure() {
		String input = "";
		service.getInventoryDetails(input);
	
		}
		
		
	}

