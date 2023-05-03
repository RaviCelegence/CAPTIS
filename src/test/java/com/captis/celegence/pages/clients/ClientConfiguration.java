package com.captis.celegence.pages.clients;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.captis.celegence.base.BasePage;
import com.captis.celegence.pages.clients.clientconfiguration.DUE;
import com.captis.celegence.pages.clients.clientconfiguration.General;
import com.captis.celegence.pages.clients.clientconfiguration.SoTA;

public class ClientConfiguration extends BasePage {
	private final By generalSection =  By.cssSelector("div.sections a:nth-of-type(1)");
	private final By dUEsection =  By.cssSelector("div.sections a:nth-of-type(2)");
	private final By soTAsection =  By.cssSelector("div.sections a:nth-of-type(3)");

	public ClientConfiguration(WebDriver driver) {
		super(driver);	
	}

	public General clickGeneralSection() {
		wait.until(ExpectedConditions.elementToBeClickable(generalSection)).click();
		return new General(driver);
	}
	
	public DUE clickDUESection() {
		wait.until(ExpectedConditions.elementToBeClickable(dUEsection)).click();
		return new DUE(driver);
	}
	
	public SoTA clickSoTASection() {
		wait.until(ExpectedConditions.elementToBeClickable(soTAsection)).click();
		return new SoTA(driver);
	}
}
