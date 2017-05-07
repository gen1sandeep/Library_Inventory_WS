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
		info.setIsbn(resultSet.getString("ISBN"));
		info.setBookId(resultSet.getInt("AVAILABLE_COUNT"));
		info.setBookStatus(resultSet.getString("ISSUED_COUNT"));
		info.setShelfDetails(resultSet.getString("ARCHIVE_COUNT"));		
		return info;
	}
}