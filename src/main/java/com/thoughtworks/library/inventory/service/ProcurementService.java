package com.thoughtworks.library.inventory.service;

import com.thoughtworks.library.inventory.model.BookProcurementInfo;

public interface ProcurementService {

	public long procureBook(BookProcurementInfo info);
	public BookProcurementInfo getProcurementDetails(long bookId);
}
