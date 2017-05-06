package com.thoughtworks.library.inventory.dbaccess;

import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;
import org.skife.jdbi.v2.DBI;

import com.thoughtworks.library.inventory.model.BookInventoryInfo;

public class BookingAvailabilityDAOTest{

	BookAvailabilityDAO dao ;
	@Before
	public void setup(){
		try {
			Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		String url = "jdbc:derby://localhost:1527/inventorydb;user=admin;password=P@ssw0rd";
		DBI dbi = new DBI(url);
		dao = dbi.onDemand(BookAvailabilityDAO.class);			
		
	};
	
	//Failure test
	@Test	
	public void findBookAvailabilityInfo() {
		
		BookInventoryInfo info =dao.findBookAvailabilityInfo("abc");
		if(info !=null){
			fail("expected null response");
		}
	}

	//success test
		@Test	
		public void findBookAvailabilityInfoForSuccess() {
			
			String isbn="978-3-16-148410-0";
			BookInventoryInfo info =dao.findBookAvailabilityInfo(isbn);
			assert(info.getISBN().equals(isbn));
			assert(info.getISBN().equals(isbn));
		}

}
