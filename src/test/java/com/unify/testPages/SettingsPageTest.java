package com.unify.testPages;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.unify.CommonsClass.CommonClass;
import com.unify.Pages.DashBoardPage;
import com.unify.Pages.LoginPage;
import com.unify.Pages.SettingsPage;
import com.unify.base.TestBase;

public class SettingsPageTest extends TestBase {
	Logger logger = Logger.getLogger(SettingsPageTest.class);

	LoginPage loginPage;
	SoftAssert assrt;
	DashBoardPage dashboard;
	CommonClass comon;
	SettingsPage sp;



	public SettingsPageTest() {
		super();
	}


	@BeforeMethod
	public void setup(){
		loginPage = new LoginPage();
		dashboard = new DashBoardPage();
		comon = new CommonClass();
		sp = new SettingsPage();
		assrt = new SoftAssert();
		dashboard = loginPage.Login(prop.getProperty("username"), prop.getProperty("password"), prop.getProperty("domain"));

	}


	//@Test
	public void VerifySetingsMasterData(){


		Boolean VerifySettigsPage = comon.mouseoverThreeEements(sp.setngs, sp.masterStngs, sp.masterDomian);
		assrt.assertTrue(VerifySettigsPage, "Mouser over not working to click on master data under Settings");

		String title =	driver.getTitle();
		System.out.println("Page Title is : "+title);
		assrt.assertEquals(title, "Master Data");

		Boolean  VerifyPageData = comon.isPagedisplaying(sp.pageData);
		assrt.assertNotNull(VerifyPageData);

		assrt.assertAll();

	}


	@Test
	public void VerifyChartOfAccount() throws InterruptedException
	{
		Boolean VerifySettigsPage = comon.mouseoverThreeEements(sp.setngs, sp.masterStngs, sp.masterDomian);
		assrt.assertTrue(VerifySettigsPage, "Mouser over not working to click on master data under Settings");

		Boolean verifyClickOnFinance = comon.Openlinks(sp.fnance);
		assrt.assertTrue(verifyClickOnFinance, "Finance link is not clickable");

		if (verifyClickOnFinance) {

			Boolean verifyClickOnCOA = comon.Openlinks(sp.coa);
			assrt.assertTrue(verifyClickOnCOA, "COA link is not clickable");

			String COAtitle =	driver.getTitle();
			System.out.println("Page Title is : "+COAtitle);
			assrt.assertEquals(COAtitle, "Master Data");

			String coaHeader = comon.GetAvailableText(sp.coaHeader);
			assrt.assertEquals(coaHeader, "Chart Of Account (COA) List");
			
			Boolean verifyAddCOA = comon.Openlinks(sp.coaPlusIcon);
			assrt.assertTrue(verifyAddCOA, "COA Add link is not clickable");
			
			if (verifyAddCOA==true) {
				
				Boolean verifyCancelCOA = comon.Openlinks(sp.coaCancel);
				assrt.assertTrue(verifyCancelCOA, "Cancel button not working on COA field");
				
				driver.manage().window().maximize();
				
			} else {

			}
			

		} else
		{
			logger.info("Finance Tab is not opens.");
		}

		assrt.assertAll();


	}










	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

}