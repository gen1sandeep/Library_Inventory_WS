package com.thoughtworks.library.inventory.service;

import com.thoughtworks.library.inventory.dbaccess.BookAvailabilityDAO;
import com.thoughtworks.library.inventory.model.BookInventoryInfo;

public class BookAvailabilitySearchServiceImpl implements BookAvailabilitySearchService {

	private BookAvailabilityDAO bookAvailabilityDAO;
	public BookAvailabilitySearchServiceImpl(BookAvailabilityDAO dao) {
		bookAvailabilityDAO = dao;
	}

	@Override
	public BookInventoryInfo getInventoryDetails(String ISBN) {

        BookInventoryInfo info= bookAvailabilityDAO.findBookAvailabilityInfo("978-3-16-148412-0");
        
        return info;
	}

}
