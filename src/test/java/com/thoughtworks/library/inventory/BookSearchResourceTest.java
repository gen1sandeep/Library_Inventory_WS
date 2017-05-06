package com.thoughtworks.library.inventory;
import java.io.IOException;

import org.junit.Rule;
import org.junit.Test;

import com.thoughtworks.library.inventory.api.resources.BookSearchResource;
import com.thoughtworks.library.inventory.model.BookInventoryInfo;

import io.dropwizard.testing.junit.ResourceTestRule;

public class BookSearchResourceTest {

    @Rule
    public final ResourceTestRule bookSearch = ResourceTestRule.builder()
            .addResource(new BookSearchResource(new InjectionUtil().getBookingSerachService()))
            .build();

    @Test
    public void testbookSearch() throws IOException {
    	/*String input = "978-3-16-148412-0";
        // Hit the endpoint and get the raw json string
    	BookInventoryInfo resp = bookSearch.client().target("/books")
                .queryParam("isbn", "dropwizard")
                .request().get(BookInventoryInfo.class);

        assert(resp.getISBN().equalsIgnoreCase(input));*/
    }

}