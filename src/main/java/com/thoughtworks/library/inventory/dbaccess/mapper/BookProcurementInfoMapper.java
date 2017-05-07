package com.thoughtworks.library.inventory.dbaccess.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import com.thoughtworks.library.inventory.model.BookProcurementInfo;

public class BookProcurementInfoMapper implements ResultSetMapper<BookProcurementInfo> {

	@Override
	public BookProcurementInfo map(int idx, ResultSet resultSet, StatementContext ctx) throws SQLException {
		BookProcurementInfo info = new BookProcurementInfo();
		info.setBookId(resultSet.getLong("BOOK_ID"));
		info.setBookStatus(resultSet.getString("BOOK_STATUS"));
		info.setIsbn(resultSet.getString("ISBN"));		
		info.setShelfDetails(resultSet.getString("SHELF_DETAILS"));		
		return info;
	}
}