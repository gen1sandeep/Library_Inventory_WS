package com.thoughtworks.library.inventory.service;

import com.thoughtworks.library.inventory.model.BookAvailabilityInfo;

/**
 * definition for book availability service 
 * @author Sandeep_Alla
 *
 */
public interface BookAvailabilitySearchService {

	public BookAvailabilityInfo getInventoryDetails(String ISBN);
}
