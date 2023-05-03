package com.captis.celegence.tests;

import org.testng.annotations.Test;

import com.captis.celegence.base.BaseTest;
import com.captis.celegence.pages.Clients;
import com.captis.celegence.pages.DashBoard;
import com.captis.celegence.pages.LoginPage;
import com.captis.celegence.pages.clients.ClientConfiguration;

public class SampleTestCase extends BaseTest {	
	
	@Test
	public void createClientTest() throws InterruptedException {
		new LoginPage(getDriver()).loadEnvironment().enterUserName().enterPassword().clickSubmit();
		Thread.sleep(10000);
		DashBoard dashBoard = new DashBoard(getDriver());
		Clients client = dashBoard.gotoClients().clickAddClientButton().enterName(data.getValue("ClientName")).clickSaveClient();
		ClientConfiguration clientConfig = client.selectClient(data.getValue("ClientName"))
				.clickConfigurationInSidePanel().addNewConfig().enterConfigName(data.getValue("ConfigName"))
				.clickSaveBtn();
		clientConfig.clickGeneralSection().selectDatabase(data.getValue("DataBase")).closeGeneral();
		clientConfig.clickDUESection().addL1ExclusionReason(data.getValues("L1ExcReason")).addL2ExclusionReason(data.getValues("L2ExcReason")).addArticlePropText(data.getValueset("AddnArticle1", 3));

	}
	
	@Test
	public void createClientTest1() {
		new LoginPage(getDriver()).loadEnvironment();
		DashBoard dashBoard = new DashBoard(getDriver());
		Clients client = dashBoard.gotoClients().clickAddClientButton().enterName(data.getValue("ClientName")).clickSaveClient();
		ClientConfiguration clientConfig = client.selectClient(data.getValue("ClientName"))
				.clickConfigurationInSidePanel().addNewConfig().enterConfigName(data.getValue("ConfigName"))
				.clickSaveBtn();
		clientConfig.clickGeneralSection().selectDatabase(data.getValue("DataBase")).closeGeneral();
		clientConfig.clickDUESection().addL1ExclusionReason(data.getValues("L1ExcReason"));
	}
	
	
}
