package com.captis.celegence.pages.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.captis.celegence.base.BasePage;
import com.captis.celegence.pages.Clients;
import com.captis.celegence.pages.DashBoard;
import com.captis.celegence.pages.Projects;
import com.captis.celegence.pages.Users;

public class Menu extends BasePage {
	private final By dashBoardbutton = By.cssSelector("div.entries>ul>li:nth-of-type(1)");
	private final By projectsButton = By.cssSelector("div.entries>ul>li:nth-of-type(2)");
	private final By usersButton = By.cssSelector("div.entries>ul>li:nth-of-type(3)");
	private final By clientsButton = By.cssSelector("div.entries>ul>li:nth-of-type(4)");

	public Menu(WebDriver driver) {
		super(driver);
	}

	public DashBoard clickMenuDashBoardbutton() {
		wait.until(ExpectedConditions.elementToBeClickable(dashBoardbutton)).click();
		return new DashBoard(driver);
	}

	public Projects clickMenuProjectsdbutton() {
		wait.until(ExpectedConditions.elementToBeClickable(projectsButton)).click();
		return new Projects(driver);
	}

	public Users clickMenuUsersbutton() {
		wait.until(ExpectedConditions.elementToBeClickable(usersButton)).click();
		return new Users(driver);
	}

	public Clients clickMenuClientsbutton() {
		wait.until(ExpectedConditions.elementToBeClickable(clientsButton)).click();
		return new Clients(driver);
	}
}
