package com.captis.celegence.base;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.captis.celegence.drivermanager.DriverFactory;
import com.captis.celegence.drivermanager.ManageDriver;
import com.captis.celegence.enums.BrowserType;
import com.captis.celegence.utilities.JsonConverter;
import com.captis.celegence.utilities.JsonExtract;

public class BaseTest {
	private ThreadLocal<ManageDriver> driverManager = new ThreadLocal<ManageDriver>();
	private ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	private JsonConverter jsonConverter = new JsonConverter();
	private int testRunCount = 0;
	protected JsonExtract data;

	private void setDriverManager(ManageDriver driverManager) {
		this.driverManager.set(driverManager);
	}

	private ManageDriver getDriverManager() {
		return this.driverManager.get();
	}

	private void setDriver(WebDriver driver) {
		this.driver.set(driver);
	}

	protected WebDriver getDriver() {
		return this.driver.get();
	}

	@BeforeMethod
	public void setUp(Method method) {
		String excelPath = System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\TestDataSheet.xlsx";
		String sheetName = "TestData";
		if (testRunCount == 0)
			jsonConverter.convertToJson(excelPath, sheetName);
		data = new JsonExtract(method.getName());
		String browser = System.getProperty("browser", "CHROME");
		setDriverManager(DriverFactory.getManager(BrowserType.valueOf(browser)));
		setDriver(getDriverManager().getDriver());
		testRunCount++;
	}

	@AfterMethod
	public void quitDriver() {
		getDriver().quit();
	}
}
