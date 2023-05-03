package com.captis.celegence.pages.clients.clientconfiguration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.captis.celegence.base.BasePage;

public class SoTA extends BasePage {
	private final By enableSoTABtn = By.xpath("//div[text()='Enable SoTA']//preceding-sibling::button");
	private final By enableFullSoTAWF = By
			.xpath("//div[text()='Enable Full SoTA Workflow']//preceding-sibling::button");

	public SoTA(WebDriver driver) {
		super(driver);
	}

	public SoTA enableSoTA() {
		wait.until(ExpectedConditions.elementToBeClickable(enableSoTABtn)).click();
		return this;
	}

	public SoTA enableFullSoTAWorkFlow() {
		wait.until(ExpectedConditions.elementToBeClickable(enableFullSoTAWF)).click();
		return this;
	}
}
