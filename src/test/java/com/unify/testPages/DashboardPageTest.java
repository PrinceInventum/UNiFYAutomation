package com.unify.testPages;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.unify.CommonsClass.CommonClass;
import com.unify.Pages.DashBoardPage;
import com.unify.Pages.LoginPage;
import com.unify.base.TestBase;

public class DashboardPageTest extends TestBase {
	Logger logger = Logger.getLogger(DashboardPageTest.class);

	LoginPage loginPage;
	SoftAssert assrt;
	DashBoardPage dashboard;
	CommonClass comon;
	public DashboardPageTest() {
		super();
	}


	@BeforeMethod
	public void setup(){
		loginPage = new LoginPage();
		dashboard = new DashBoardPage();
		comon = new CommonClass();
		assrt = new SoftAssert();
		dashboard = loginPage.Login(prop.getProperty("username"), prop.getProperty("password"), prop.getProperty("domain"));

	}


	@Test
	public void VerifyLogoOnDashboard(){


		Boolean vrifylogo =	dashboard.logo.isDisplayed();
		assrt.assertTrue(vrifylogo,"Logo is not displaying on Unify dashboard");
		assrt.assertAll();	
	}


	@Test
	public void VerifyAllLinks(){
		
		assrt.assertTrue(comon.isPagedisplaying(dashboard.allPages));
		assrt.assertAll();	
	}


	@Test
	public void VerifyWelcomeLinks(){
	Boolean verifyAllElements = comon.isPagedisplaying(dashboard.wlcmText);
	assrt.assertTrue(verifyAllElements);	
	assrt.assertAll();
	}




	@AfterMethod
	public void tearDown(){
		driver.quit();
	}



}