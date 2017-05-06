package com.thoughtworks.library.inventory;


import org.skife.jdbi.v2.DBI;

import com.thoughtworks.library.inventory.api.resources.InventoryHealthCheckResource;
import com.thoughtworks.library.inventory.dbaccess.BookAvailabilityDAO;
import com.thoughtworks.library.inventory.model.BookInventoryInfo;

import io.dropwizard.Application;
import io.dropwizard.jdbi.DBIFactory;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class InventoryApplication extends Application<InventoryConfiguration> {
	
    public static void main(String[] args) throws Exception {
        new InventoryApplication().run(args);
    }



    @Override
    public void initialize(Bootstrap<InventoryConfiguration> bootstrap) {
     
    }

    @Override
    public void run(InventoryConfiguration configuration, Environment environment) {
    	
		// initialize JDBI
		DBIFactory factory = new DBIFactory();
		final DBI jdbi = factory.build(environment, configuration.getDataSourceFactory(), "derby");
    	// use metrics healthchecks
    	environment.jersey().register(new InventoryHealthCheckResource(environment.healthChecks()));
    	
    	// basic echo service       
    	//environment.jersey().register(RolesAllowedDynamicFeature.class);

    }
}
