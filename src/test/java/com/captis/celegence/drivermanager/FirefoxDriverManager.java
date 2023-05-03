package com.captis.celegence.drivermanager;

import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FirefoxDriverManager extends ManageDriver {

	@Override
	public void createDriver() {
		WebDriverManager.firefoxdriver().cachePath("Drivers").setup();
		driver = new FirefoxDriver();
		driver.manage().window().maximize();		
	}
}
