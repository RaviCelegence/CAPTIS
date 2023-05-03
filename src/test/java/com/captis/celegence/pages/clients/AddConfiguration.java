package com.captis.celegence.pages.clients;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.captis.celegence.base.BasePage;

public class AddConfiguration extends BasePage {
	private final By configName = By.cssSelector("input#name");
	private final By saveButton = By.xpath("//span[text()='Save']");

	public AddConfiguration(WebDriver driver) {
		super(driver);
	}
	
	public AddConfiguration enterConfigName(String ConfigName) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(configName)).sendKeys(ConfigName);
		return this;
	}
	
	public ClientConfiguration clickSaveBtn() {
		wait.until(ExpectedConditions.elementToBeClickable(saveButton)).click();
		return new ClientConfiguration(driver);
	}
}
