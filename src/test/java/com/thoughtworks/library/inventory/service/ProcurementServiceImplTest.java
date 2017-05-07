package com.thoughtworks.library.inventory.service;

import org.junit.Test;

import com.thoughtworks.library.inventory.InjectionUtil;
import com.thoughtworks.library.inventory.common.exception.IncorrectRequestDataException;
import com.thoughtworks.library.inventory.model.BookProcurementInfo;

public class ProcurementServiceImplTest {

	@Test
	public final void testProcurementService() {
		ProcurementService serviceImpl = new ProcurementServiceImpl(new InjectionUtil().getProcurementDAO());
		BookProcurementInfo info = new BookProcurementInfo();
		info.setBookStatus("A");
		info.setIsbn("978-3-16-148418-0");
		info.setShelfDetails("14");			
		long bookdid = serviceImpl.procureBook(info);
		assert(bookdid!=0);
	}
	
	@Test(expected=IncorrectRequestDataException.class)
	public final void testProcurementServiceforFailureNOISBN() {
		ProcurementService serviceImpl = new ProcurementServiceImpl(new InjectionUtil().getProcurementDAO());
		BookProcurementInfo info = new BookProcurementInfo();		
		info.setIsbn("");		
		serviceImpl.procureBook(info);		
	}
	
	@Test(expected=IncorrectRequestDataException.class)
	public final void testProcurementServiceforFailureInvalidISBN() {
		ProcurementService serviceImpl = new ProcurementServiceImpl(new InjectionUtil().getProcurementDAO());
		BookProcurementInfo info = new BookProcurementInfo();		
		info.setIsbn("abc-def");		
		serviceImpl.procureBook(info);		
	}

	@Test(expected=IncorrectRequestDataException.class)
	public final void testProcurementwithInvalidBookStatus() {
		ProcurementService serviceImpl = new ProcurementServiceImpl(new InjectionUtil().getProcurementDAO());
		BookProcurementInfo info = new BookProcurementInfo();		
		info.setIsbn("978-3-16-148418-0");
		info.setBookStatus("");
		serviceImpl.procureBook(info);		
	}

}
