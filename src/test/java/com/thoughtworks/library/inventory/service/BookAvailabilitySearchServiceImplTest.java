package com.thoughtworks.library.inventory.service;

import javax.validation.constraints.AssertTrue;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import com.thoughtworks.library.inventory.model.BookAvailabilityInfo;

public class BookAvailabilitySearchServiceImplTest {

	private BookAvailabilitySearchService service;
	@Before
	public void setup(){
		service = new BookAvailabilitySearchServiceImpl();
	}
	
	@Test
	public final void testBookAvailabilitySearchServiceImpl() {
		String input = "978-3-16-148412-0";
		BookAvailabilityInfo result = service.getInventoryDetails(input);
		if(result == null){			
			fail ("Exepected valid result, but received null response");
		}else{
			assert(result.getISBN().equalsIgnoreCase(input));}
		}
	
	@Test(expected=Exception.class)
	public final void testBookAvailabilitySearchServiceImplforFailure() {
		String input = "";
		service.getInventoryDetails(input);
	
		}
		
		
	}

