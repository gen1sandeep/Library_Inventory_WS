package com.thoughtworks.library.inventory.api.resources;

import org.glassfish.hk2.utilities.binding.AbstractBinder;

import com.thoughtworks.library.inventory.service.BookAvailabilitySearchServiceImpl;

public class DependencyBinder extends AbstractBinder {

	@Override
	protected void configure() {
		bind(BookAvailabilitySearchServiceImpl.class).to(BookSearchResource.class);
		
	}

}
