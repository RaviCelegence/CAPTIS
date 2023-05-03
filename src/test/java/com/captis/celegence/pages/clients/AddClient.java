package com.captis.celegence.pages.clients;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.captis.celegence.base.BasePage;
import com.captis.celegence.pages.Clients;

public class AddClient extends BasePage {
	private final By name = By.id("name");
	private final By saveButton = By.xpath("//span[text()='Save']");
	
	public AddClient(WebDriver driver) {
		super(driver);		
	}
	
	public AddClient enterName(String clientName) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(name)).sendKeys(clientName);
		return this;
	}
	
	public Clients clickSaveClient() {
		wait.until(ExpectedConditions.elementToBeClickable(saveButton)).click();
		return new Clients(driver);
	}
	

}
