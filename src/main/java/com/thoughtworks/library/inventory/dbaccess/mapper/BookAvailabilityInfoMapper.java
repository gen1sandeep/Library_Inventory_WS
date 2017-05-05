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
		info.setISBN(resultSet.getString("Id"));
		info.setAvalilableBookCount(resultSet.getInt("Id"));
		info.setIssuedBookCount(resultSet.getInt("Id"));
		info.setTotalBookCount(resultSet.getInt("Id"));
		return info;
	}
}