package com.thoughtworks.library.inventory.service;

import com.thoughtworks.library.inventory.dbaccess.BookAvailabilityDAO;
import com.thoughtworks.library.inventory.model.BookAvailabilityInfo;

public class BookAvailabilitySearchServiceImpl implements BookAvailabilitySearchService {

	private BookAvailabilityDAO bookAvailabilityDAO;
	public BookAvailabilitySearchServiceImpl(BookAvailabilityDAO dao) {
		bookAvailabilityDAO = dao;
	}

	@Override
	public BookAvailabilityInfo getInventoryDetails(String ISBN) {

        BookAvailabilityInfo info= bookAvailabilityDAO.findBookAvailabilityInfo("978-3-16-148412-0");
        
        return info;
	}

}
