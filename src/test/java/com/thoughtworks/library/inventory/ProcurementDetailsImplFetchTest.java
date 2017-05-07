package com.thoughtworks.library.inventory;

import org.junit.Test;

import com.thoughtworks.library.inventory.common.exception.DataNotFoundException;
import com.thoughtworks.library.inventory.common.exception.IncorrectRequestDataException;
import com.thoughtworks.library.inventory.model.BookProcurementInfo;
import com.thoughtworks.library.inventory.service.ProcurementService;
import com.thoughtworks.library.inventory.service.ProcurementServiceImpl;

public class ProcurementDetailsImplFetchTest {

	@Test
	public final void testProcurementService() {
		long bookId = 2;
		ProcurementService serviceImpl = new ProcurementServiceImpl(new InjectionUtil().getProcurementDAO());			
		BookProcurementInfo info = serviceImpl.getProcurementDetails(bookId);
		assert(info.getIsbn().length()>1);
		assert(info.getBookStatus().length()==1);
	}
	
	@Test(expected=IncorrectRequestDataException.class)
	public final void testProcurementDetailsFailureForEmptry() {
		long bookId = 0;
		ProcurementService serviceImpl = new ProcurementServiceImpl(new InjectionUtil().getProcurementDAO());			
		serviceImpl.getProcurementDetails(bookId);			
	}
	
	@Test(expected=DataNotFoundException.class)
	public final void testProcurementDetailsFailureForInvalidBookID() {
		long bookId = 1222222222;
		ProcurementService serviceImpl = new ProcurementServiceImpl(new InjectionUtil().getProcurementDAO());			
		serviceImpl.getProcurementDetails(bookId);		
	}
}
