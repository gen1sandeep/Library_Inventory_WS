package com.thoughtworks.library.inventory.service;

import com.thoughtworks.library.inventory.model.BookInventoryInfo;

/**
 * definition for book availability service 
 * @author Sandeep_Alla
 *
 */
public interface BookAvailabilitySearchService {

	public BookInventoryInfo getInventoryDetails(String ISBN);
}
