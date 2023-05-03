package com.captis.celegence.base;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	protected WebDriver driver;
	protected WebDriverWait wait;
	protected Actions actions;

	public BasePage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		actions = new Actions(driver);
	}

	// common WebElement to add tags,questions etc
	// for different sections in client configuration
	public void clickAddButton(String sectionName) {
		By locator = By.xpath("//div[text()='" + sectionName + "']//following::button[2]");
		wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
	}
}
