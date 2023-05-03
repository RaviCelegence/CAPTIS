package com.captis.celegence.pages.clients.clientconfiguration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.captis.celegence.base.BasePage;
import com.captis.celegence.pages.clients.ClientConfiguration;

public class General extends BasePage {

	private final By tagNameField = By.cssSelector("input#label");
	private final By tagColorField = By.cssSelector("div.ant-select-selector");
	private final By color = By.cssSelector("div[aria-selected='false']:nth-of-type(6) >div ");
	private final By closeButton = By.xpath("(//span[@aria-label='close'])[3]");
	

	public General(WebDriver driver) {
		super(driver);
	}

	public General selectDatabase(String Database) {
		By databaseElement = By.xpath("//div[text()='" + Database + "']//preceding-sibling::div");
		wait.until(ExpectedConditions.elementToBeClickable(databaseElement)).click();
		return this;
	}

	public General addTagNames(String Name) {
		clickAddButton("Content Tags");
		wait.until(ExpectedConditions.visibilityOfElementLocated(tagNameField)).sendKeys(Name);
		return this;
	}

	public General addColor() {
		wait.until(ExpectedConditions.elementToBeClickable(tagColorField)).click();
		wait.until(ExpectedConditions.elementToBeClickable(color)).click();
		return this;
	}
	
	public ClientConfiguration closeGeneral() {
		wait.until(ExpectedConditions.elementToBeClickable(closeButton)).click();
		return new ClientConfiguration(driver);
	}
}
