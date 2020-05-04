package com.rest.ops.commons.datahandlers;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesHandler {

	Properties props = new Properties();
	public PropertiesHandler() {
		
		try {
			props.load(new FileInputStream("./src/test/resources/application.properties"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public String getProperty(String key) {
		return props.getProperty(key);
	}
}
