
package com.thoughtworks.library.inventory.dbaccess;

import org.skife.jdbi.v2.DBI;
import org.skife.jdbi.v2.Handle;

import com.thoughtworks.library.inventory.common.InventoryAppConstants;
import com.thoughtworks.library.inventory.dbaccess.mapper.BookAvailabilityInfoMapper;
import com.thoughtworks.library.inventory.model.BookAvailabilityInfo;

public class BookAvailabilityDAO {

	private final DBI jdbi;


	public BookAvailabilityDAO(DBI jdbi) {
		this.jdbi = jdbi;
	}

	public BookAvailabilityInfo findByISBN(String isbn) {
		BookAvailabilityInfo info;
		String sql= "SELECT * FROM " + InventoryAppConstants.STOCK_DETAILS_TABLE_NAME +
					" WHERE "
					+ "ISBN = :isbn";
		try (Handle handle = jdbi.open()) {		

			info = jdbi.withHandle((Handle h) -> {
				return h.createQuery(sql).map(new BookAvailabilityInfoMapper()).bind("ISBN", isbn).first();
			});
		}
		return info;
	}

}
