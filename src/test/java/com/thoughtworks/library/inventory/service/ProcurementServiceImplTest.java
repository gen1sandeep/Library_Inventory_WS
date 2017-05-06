package com.thoughtworks.library.inventory.service;

import org.junit.Test;

import com.thoughtworks.library.inventory.InjectionUtil;

public class ProcurementServiceImplTest {

	@Test
	public final void testProcurementService() {
		ProcurementService serviceImpl = new ProcurementServiceImpl(new InjectionUtil().getBookingAvailabiltyDAO()
	}

}
