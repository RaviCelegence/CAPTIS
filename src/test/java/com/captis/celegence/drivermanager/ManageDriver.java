package com.captis.celegence.drivermanager;

import org.openqa.selenium.WebDriver;

public abstract class ManageDriver {
	protected WebDriver driver;	
	protected abstract void createDriver();

	public void quitDriver() {
		if (driver != null) {
			driver.quit();
		}
	}

	public WebDriver getDriver() {
		if (driver == null) {
			createDriver();
		}
		return driver;
	}
}
