package com.captis.celegence.pages;

import org.openqa.selenium.WebDriver;

import com.captis.celegence.base.BasePage;
import com.captis.celegence.pages.components.Menu;

public class DashBoard extends BasePage {
	private Menu menu;

	public DashBoard(WebDriver driver) {
		super(driver);
		menu = new Menu(driver);
	}

	public Clients gotoClients() {
		menu.clickMenuClientsbutton();
		return new Clients(driver);
	}
}
