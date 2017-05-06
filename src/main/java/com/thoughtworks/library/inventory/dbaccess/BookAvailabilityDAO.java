package com.thoughtworks.library.inventory.dbaccess;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import com.thoughtworks.library.inventory.dbaccess.mapper.BookAvailabilityInfoMapper;
import com.thoughtworks.library.inventory.model.BookAvailabilityInfo; 
 
@RegisterMapper(BookAvailabilityInfoMapper.class) 
public interface BookAvailabilityDAO { 
 
    
	//@SqlQuery("SELECT ISBN, BOOK_STATUS,count(*) from STOCK_DETAILS where ISBN = ':isbn' group by ISBN,BOOK_STATUS") 
    @SqlQuery("select ISBN, TOTAL_COUNT, ARCHIVE_COUNT, AVAILABLE_COUNT,ISSUED_COUNT  from INVENTORY_SUMMARY where ISBN = :isbn") 
    BookAvailabilityInfo findBookAvailabilityInfo(@Bind("isbn") final String isbn); 


	
}
