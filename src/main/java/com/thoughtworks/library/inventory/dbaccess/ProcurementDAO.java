package com.thoughtworks.library.inventory.dbaccess;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.GetGeneratedKeys;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import com.thoughtworks.library.inventory.dbaccess.mapper.BookProcurementInfoMapper;
import com.thoughtworks.library.inventory.model.BookProcurementInfo;

@RegisterMapper(BookProcurementInfoMapper.class)
public interface ProcurementDAO {

	@SqlUpdate("insert into STOCK_DETAILS(ISBN,BOOK_STATUS,SHELF_DETAILS,CREATION_TIME,LAST_MOD_TIME)" + "values"
			+ "(:isbn,:bookStatus,:shelfDetails, current_date,current_date)")
	@GetGeneratedKeys
	long insertRecord(@BindBean final BookProcurementInfo inputVO);

	@SqlQuery("SELECT BOOK_ID, ISBN, BOOK_STATUS, SHELF_DETAILS  from STOCK_DETAILS WHERE BOOK_ID = :bookId\n")
	BookProcurementInfo getBookProcurementInfo(@Bind("bookId") long bookId);

}
