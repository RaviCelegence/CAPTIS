package com.captis.celegence.drivermanager;

import com.captis.celegence.enums.BrowserType;

public class DriverFactory {

	public static ManageDriver getManager(BrowserType browser) {
		switch (browser) {
			case CHROME:
				return new ChromeDriverManager();
			case FIREFOX:
				return new FirefoxDriverManager();
			default:
				throw new IllegalStateException("Invalid browser type value: " + browser);
		}
	}
}
