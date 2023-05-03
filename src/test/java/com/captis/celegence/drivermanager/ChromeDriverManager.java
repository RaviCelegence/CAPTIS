package com.captis.celegence.drivermanager;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ChromeDriverManager extends ManageDriver {

	@Override
	public void createDriver() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		options.addArguments("start-maximized"); // open Browser in maximized mode
		options.addArguments("disable-infobars"); // disabling infobars
		options.addArguments("--disable-extensions"); // disabling extensions
		options.addArguments("--disable-gpu"); // applicable to windows os only
		options.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
		options.addArguments("--no-sandbox");
		options.addArguments("--user-data-dir=C:/Users/rrkumar/AppData/Local/Google/Chrome/User Data");

		WebDriverManager.chromedriver().cachePath("Drivers").setup();
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
	}
}
