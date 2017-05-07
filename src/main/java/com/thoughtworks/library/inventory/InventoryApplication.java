package com.thoughtworks.library.inventory;

import org.skife.jdbi.v2.DBI;

import com.thoughtworks.library.inventory.api.resources.BookSearchResource;
import com.thoughtworks.library.inventory.api.resources.InventoryHealthCheckResource;
import com.thoughtworks.library.inventory.api.resources.ProcurementDetailsResource;
import com.thoughtworks.library.inventory.common.exception.CommonServerSideErrorMapper;
import com.thoughtworks.library.inventory.common.exception.DataNotFoundExceptionMapper;
import com.thoughtworks.library.inventory.common.exception.IncorrectRequestExceptionMapper;
import com.thoughtworks.library.inventory.dbaccess.BookAvailabilityDAO;
import com.thoughtworks.library.inventory.dbaccess.ProcurementDAO;
import com.thoughtworks.library.inventory.service.BookAvailabilitySearchServiceImpl;
import com.thoughtworks.library.inventory.service.ProcurementServiceImpl;

import io.dropwizard.Application;
import io.dropwizard.jdbi.DBIFactory;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class InventoryApplication extends Application<InventoryConfiguration> {

	public static void main(String[] args) throws Exception {
		new InventoryApplication().run(args);
	}

	@Override
	public String getName() {
		return "inventory";
	}

	@Override
	public void initialize(Bootstrap<InventoryConfiguration> bootstrap) {

	}

	@Override
	public void run(InventoryConfiguration configuration, Environment environment) {

		// use metrics healthchecks
		environment.jersey().register(new InventoryHealthCheckResource(environment.healthChecks()));

		// initialize JDBI
		DBIFactory factory = new DBIFactory();
		final DBI jdbi = factory.build(environment, configuration.getDataSourceFactory(), "derby");

		// temporary solution -- To be addressed by DI library
		BookAvailabilityDAO bookAvailabilityDAO = jdbi.onDemand(BookAvailabilityDAO.class);
		// temporarty solution -- To be addressed by DI library

		environment.jersey()
				.register(new BookSearchResource(new BookAvailabilitySearchServiceImpl(bookAvailabilityDAO)));
		environment.jersey().register(
				new ProcurementDetailsResource(new ProcurementServiceImpl(jdbi.onDemand(ProcurementDAO.class))));

		// Register the custom ExceptionMapper(s)
		environment.jersey().register(new DataNotFoundExceptionMapper());
		environment.jersey().register(new IncorrectRequestExceptionMapper());
		environment.jersey().register(new CommonServerSideErrorMapper());
	}
}
