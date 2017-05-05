
package com.thoughtworks.library.inventory.dbaccess;

import java.util.List;
import java.util.Map;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.skife.jdbi.v2.BaseResultSetMapper;
import org.skife.jdbi.v2.DBI;
import org.skife.jdbi.v2.Handle;

import com.thoughtworks.library.inventory.common.InventoryAppConstants;


public class BookAvailabilityDAO {
	
	
	private final DBI jdbi;
	
	public BookAvailabilityDAO(DBI jdbi) {
		this.jdbi = jdbi;
	}
	
	
	
	public List<OutputTo> findAll() {
		try(Handle h = jdbi.open()){
			return h.createQuery("SELECT * FROM " + InventoryAppConstants.STOCK_DETAILS_TABLE_NAME)
					  .map(new OutputMapper())
					  .list();
		}
	}
	
	public OutputTo findById(int id) {
		try(Handle h = jdbi.open()){
			return h.createQuery("SELECT * FROM " + InventoryAppConstants.STOCK_DETAILS_TABLE_NAME + " WHERE id = :id")
					  .bind("id", id)
					  .map(new OutputMapper())
					  .first();
		}
	}
	
	
}
