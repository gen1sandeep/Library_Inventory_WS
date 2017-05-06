package com.thoughtworks.library.inventory.dbaccess.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import com.thoughtworks.library.inventory.model.BookInventoryInfo;

public class BookAvailabilityInfoMapper implements ResultSetMapper<BookInventoryInfo> {

	@Override
	public BookInventoryInfo map(int idx, ResultSet resultSet, StatementContext ctx) throws SQLException {
		BookInventoryInfo info = new BookInventoryInfo();
		info.setISBN(resultSet.getString("ISBN"));
		info.setAvalilableBookCount(resultSet.getInt("AVAILABLE_COUNT"));
		info.setIssuedBookCount(resultSet.getInt("ISSUED_COUNT"));
		info.setArchivedBookCount(resultSet.getInt("ARCHIVE_COUNT"));
		return info;
	}
}