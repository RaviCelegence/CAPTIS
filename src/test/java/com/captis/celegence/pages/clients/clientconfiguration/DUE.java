package com.captis.celegence.pages.clients.clientconfiguration;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.captis.celegence.base.BasePage;

public class DUE extends BasePage {
	private final By exclusionReasonL1L2Field = By.cssSelector("input#reason");
	private final By saveButton = By.cssSelector("[role='btn-ok'] span");
	private final By titleText = By.cssSelector("input#title");
	private final By helpMessageText = By.cssSelector("input#helpMessage");
	private final By addnDataType = By.xpath("//*[text()='Additional Data Type']//following::div[1]");
	// private final By selectOption = By.xpath("//*[text()='Select']");
	private final By textOption = By.xpath("//*[text()='Text']");

	public DUE(WebDriver driver) {
		super(driver);
	}

	public DUE addL1ExclusionReason(List<String> reason) {
		for (String l1Reason : reason) {
			clickAddButton("Exclusion Reasons (L1)");
			wait.until(ExpectedConditions.visibilityOfElementLocated(exclusionReasonL1L2Field)).sendKeys(l1Reason);
			wait.until(ExpectedConditions.visibilityOfElementLocated(exclusionReasonL1L2Field)).sendKeys(Keys.ENTER);
		}
		return this;
	}

	public DUE addL2ExclusionReason(List<String> reason) {
		for (String l2Reason : reason) {
			clickAddButton("Exclusion Reasons (L2)");
			wait.until(ExpectedConditions.visibilityOfElementLocated(exclusionReasonL1L2Field)).sendKeys(l2Reason);
			wait.until(ExpectedConditions.elementToBeClickable(exclusionReasonL1L2Field)).sendKeys(Keys.ENTER);
		}
		return this;
	}

	public DUE addArticlePropText(List<String> properties) {
		clickAddButton("Additional article properties (Optional)");
		wait.until(ExpectedConditions.visibilityOfElementLocated(titleText)).sendKeys(properties.get(0));
		wait.until(ExpectedConditions.visibilityOfElementLocated(helpMessageText)).sendKeys(properties.get(1));
		wait.until(ExpectedConditions.elementToBeClickable(addnDataType)).click();
		wait.until(ExpectedConditions.elementToBeClickable(textOption)).click();
		actions.moveToElement(driver.findElement(saveButton)).click().perform();
		return this;
	}

	public DUE addArticlePropText(LinkedHashMap<Integer, ArrayList<String>> map) {
		for (Map.Entry<Integer, ArrayList<String>> entry : map.entrySet()) {
			addArticlePropText(entry.getValue());
		}
		return this;
	}

	public DUE addArticlePropSelectValue(String title) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(addnDataType)).click();
		clickAddButton("Additional article properties (Optional)");
		wait.until(ExpectedConditions.visibilityOfElementLocated(titleText)).sendKeys(title);
		wait.until(ExpectedConditions.elementToBeClickable(addnDataType)).click();
		wait.until(ExpectedConditions.elementToBeClickable(textOption)).click();
		actions.moveToElement(driver.findElement(saveButton)).click().perform();
		return this;
	}
}
