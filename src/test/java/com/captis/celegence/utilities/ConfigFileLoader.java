package com.captis.celegence.utilities;

import java.util.Properties;

public class ConfigFileLoader {
	private final Properties properties;
	private static ConfigFileLoader loader;

	private ConfigFileLoader() {
		properties = PropertyLoader.loadFile("src\\test\\resources\\PropertyFiles\\config.properties");
	}

	public static ConfigFileLoader getInstance() {
		if (loader == null) {
			loader = new ConfigFileLoader();
		}
		return loader;
	}

	public String getURL() {
		String url = properties.getProperty("url");
		if (url != null)
			return url;
		else
			throw new RuntimeException("URL not specified in properties file config.properties");
	}

	public String getUsername() {
		String username = properties.getProperty("userName");
		if (username != null)
			return username;
		else
			throw new RuntimeException("Username not specified in properties file config.properties");
	}

	public String getPassword() {
		String password = properties.getProperty("password");
		if (password != null)
			return password;
		else
			throw new RuntimeException("Password not specified in properties file config.properties");
	}
}
