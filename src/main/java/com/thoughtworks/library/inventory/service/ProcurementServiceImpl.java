package com.thoughtworks.library.inventory.service;

import com.thoughtworks.library.inventory.common.exception.IncorrectRequestDataException;
import com.thoughtworks.library.inventory.model.BookProcurementInfo;

public class ProcurementServiceImpl implements ProcurementService {

	@Override
	public BookProcurementInfo procureBook(BookProcurementInfo input) {
		
		//perform validations
		if(input == null || input.getIsbn().length() <=0 ){
			throw new IncorrectRequestDataException("Request Data is Invalid. ISBN cannot be empty");
		}
		return null;
	}

}
