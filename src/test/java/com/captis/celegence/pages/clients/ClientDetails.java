package com.captis.celegence.pages.clients;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.captis.celegence.base.BasePage;

public class ClientDetails extends BasePage {
	private final By configurationInSidePanel = By.cssSelector("a[href$='config']");
	private final By addConfigButton = By.cssSelector("a[href$='config/add']");

	public ClientDetails(WebDriver driver) {
		super(driver);
	}

	public ClientDetails clickConfigurationInSidePanel() {
		wait.until(ExpectedConditions.elementToBeClickable(configurationInSidePanel)).click();
		return this;
	}

	public AddConfiguration addNewConfig() {
		wait.until(ExpectedConditions.elementToBeClickable(addConfigButton)).click();
		return new AddConfiguration(driver);
	}

}
