package com.yosael.ws;

import org.glassfish.jersey.server.ResourceConfig;

public class Config extends ResourceConfig{

	public Config(){
		packages("com.yosael.ws");
	}
	
}
