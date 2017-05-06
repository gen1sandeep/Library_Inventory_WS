package com.thoughtworks.library.inventory;


import org.skife.jdbi.v2.DBI;

import com.thoughtworks.library.inventory.api.resources.BookSearchResource;
import com.thoughtworks.library.inventory.api.resources.EchoResource;
import com.thoughtworks.library.inventory.api.resources.InventoryHealthCheckResource;
import com.thoughtworks.library.inventory.dbaccess.BookAvailabilityDAO;
import com.thoughtworks.library.inventory.service.BookAvailabilitySearchServiceImpl;

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
    	
    	//set context paths
        environment.getApplicationContext().setContextPath("/inventory/");
        environment.getAdminContext().setContextPath("/admin/");
    	
    	// use metrics healthchecks
    	environment.jersey().register(new InventoryHealthCheckResource(environment.healthChecks()));
    	
    	
		// initialize JDBI
		DBIFactory factory = new DBIFactory();
		final DBI jdbi = factory.build(environment, configuration.getDataSourceFactory(), "derby");
    	
    	// temporary solution -- To be addressed by DI library
    	   BookAvailabilityDAO bookAvailabilityDAO =  jdbi.onDemand(BookAvailabilityDAO.class);
    	// temporarty solution -- To be addressed by DI library
    	   
    	  //environment.jersey().register(new DependencyBinder());
    	  environment.jersey().register(new BookSearchResource(new BookAvailabilitySearchServiceImpl(bookAvailabilityDAO)));
    	  environment.jersey().register(new EchoResource());

    }
}
