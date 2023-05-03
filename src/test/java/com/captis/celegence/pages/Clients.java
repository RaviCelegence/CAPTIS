package com.captis.celegence.pages;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.captis.celegence.base.BasePage;
import com.captis.celegence.pages.clients.AddClient;
import com.captis.celegence.pages.clients.ClientDetails;

public class Clients extends BasePage {
	private final By addClientButton = By.cssSelector("a[href='/clients/add']");
	private final By nextPageButton = By.cssSelector("ul.ant-pagination li:last-child");
	private final By clientPageNumbers = By.cssSelector("ul.ant-pagination li>a");
	private final By loadingBar = By.cssSelector("div.http-loader");
	private final By clientNames = By.cssSelector("div.layout>div>a>div div.name");

	public Clients(WebDriver driver) {
		super(driver);
	}

	public AddClient clickAddClientButton() {
		wait.until(ExpectedConditions.elementToBeClickable(addClientButton)).click();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(loadingBar));
		return new AddClient(driver);
	}

	public int noOfClientPages() {
		List<WebElement> list = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(clientPageNumbers));
		return list.size();
	}

	public Clients clickNextClientPage() {
		wait.until(ExpectedConditions.elementToBeClickable(nextPageButton)).click();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(loadingBar));
		return this;
	}

	public Clients clickClientPageNo(int pageNO) {
		List<WebElement> pages = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(clientPageNumbers));
		pages.get(pageNO - 1).click();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(loadingBar));
		return this;
	}

	public boolean nextClientPageAvailable() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(nextPageButton)).isEnabled();
	}

	public List<WebElement> getClientListInPage(int pageNO) {
		clickClientPageNo(pageNO);
		List<WebElement> clientElements;
		clientElements = new ArrayList<WebElement>(
				wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(clientNames)));
		return clientElements;
	}

	public HashMap<WebElement, Integer> clientListWithPageNo() {
		HashMap<WebElement, Integer> clientDetails = new HashMap<WebElement, Integer>();
		int pageNo = 0;
		do {
			List<WebElement> clientElements = wait
					.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(clientNames));
			for (WebElement e : clientElements) {
				clientDetails.put(e, pageNo + 1);
			}
			clickNextClientPage();
			wait.until(ExpectedConditions.invisibilityOfElementLocated(loadingBar));
			clientDetails.clear();
			pageNo++;
		} while (pageNo < noOfClientPages());
		return clientDetails;
	}

	public ClientDetails selectClient(String clientName) {
		for (int pageNo = 1; pageNo <= noOfClientPages(); pageNo++) {
			for (WebElement e : getClientListInPage(pageNo)) {
				if (e.getText().equals(clientName)) {
					wait.until(ExpectedConditions.elementToBeClickable(e)).click();
					wait.until(ExpectedConditions.invisibilityOfElementLocated(loadingBar));
					return new ClientDetails(driver);
				}
			}
		}
		throw new IllegalStateException("UNABLE TO FIND THE CLIENT " + clientName);
	}
}
