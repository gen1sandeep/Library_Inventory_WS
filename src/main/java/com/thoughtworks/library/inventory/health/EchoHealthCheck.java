package com.thoughtworks.library.inventory.health;

import com.codahale.metrics.health.HealthCheck;


public class EchoHealthCheck extends HealthCheck {

	@Override
	protected Result check() throws Exception {
		
		// to be done
		return Result.healthy();
	}
}
