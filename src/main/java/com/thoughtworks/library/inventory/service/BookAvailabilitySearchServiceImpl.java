package com.thoughtworks.library.inventory.service;

import com.thoughtworks.library.inventory.common.exception.DataNotFoundException;
import com.thoughtworks.library.inventory.common.exception.IncorrectRequestDataException;
import com.thoughtworks.library.inventory.dbaccess.BookAvailabilityDAO;
import com.thoughtworks.library.inventory.model.BookInventoryInfo;

public class BookAvailabilitySearchServiceImpl implements BookAvailabilitySearchService {

	private BookAvailabilityDAO bookAvailabilityDAO;
	public BookAvailabilitySearchServiceImpl(BookAvailabilityDAO dao) {
		bookAvailabilityDAO = dao;
	}

	@Override
	public BookInventoryInfo getInventoryDetails(String ISBN) {

		
	
		if(ISBN==null || ISBN.length() == 0 || ISBN.matches("^[a-zA-Z]*$")){
			throw new IncorrectRequestDataException("Invalid Request Details received. Not a valid ISBN::"+ISBN);
		}
        BookInventoryInfo info= bookAvailabilityDAO.findBookAvailabilityInfo(ISBN);   
        if(info == null){
        	throw new DataNotFoundException("No Records found for ["+ ISBN +"] ISBN Number");
        }
        return info;
	}

}
