package com.captis.celegence.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.captis.celegence.base.BasePage;
import com.captis.celegence.utilities.ConfigFileLoader;

public class LoginPage extends BasePage {
	private final By email = By.id("email");
	private final By password = By.id("password");
	private final By signInButton = By.cssSelector("button[type ='submit']");
	private final By rememberMe = By.xpath("//input[@id='remember']");

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	public DashBoard clickSubmit() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(signInButton)).click();
		return new DashBoard(driver);
	}

	public LoginPage enterPassword() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(password))
				.sendKeys(ConfigFileLoader.getInstance().getPassword());
		return this;
	}

	public LoginPage enterUserName() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(email))
				.sendKeys(ConfigFileLoader.getInstance().getUsername());
		return this;
	}

	public LoginPage rememberMe() {
		actions.moveToElement(driver.findElement(rememberMe)).click().build().perform();
		return this;
	}

	public LoginPage loadEnvironment() {
		driver.get(ConfigFileLoader.getInstance().getURL());
		return this;
	}

}
