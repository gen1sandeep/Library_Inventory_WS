package com.thoughtworks.library.inventory.dbaccess.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import com.thoughtworks.library.inventory.model.BookAvailabilityInfo;

public class BookAvailabilityInfoMapper implements ResultSetMapper<BookAvailabilityInfo> {

	@Override
	public BookAvailabilityInfo map(int idx, ResultSet resultSet, StatementContext ctx) throws SQLException {
		BookAvailabilityInfo info = new BookAvailabilityInfo();
		info.setISBN(resultSet.getString("ISBN"));
		info.setAvalilableBookCount(resultSet.getInt("AVAILABLE_COUNT"));
		info.setIssuedBookCount(resultSet.getInt("ISSUED_COUNT"));
		info.setArchivedBookCount(resultSet.getInt("ARCHIVE_COUNT"));
		return info;
	}
}