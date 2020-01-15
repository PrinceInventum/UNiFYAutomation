package com.unify.testPages;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.unify.CommonsClass.CommonClass;
import com.unify.Pages.CalculateTime;
import com.unify.Pages.DashBoardPage;
import com.unify.Pages.LoginPage;
import com.unify.base.TestBase;

public class CalculateTimeTest extends TestBase {
	Logger logger = Logger.getLogger(CalculateTimeTest.class);

	LoginPage loginPage;
	SoftAssert assrt;
	DashBoardPage dashboard;
	CommonClass comon;
	CalculateTime calculate;


	public CalculateTimeTest() {
		super();
	}


	@BeforeMethod
	public void setup(){
		loginPage = new LoginPage();
		calculate = new CalculateTime();
		comon = new CommonClass();
		assrt = new SoftAssert();
		dashboard = loginPage.Login(prop.getProperty("username"), prop.getProperty("password"), prop.getProperty("domain"));

	}


	@Test
	public void veriySearchTime(){
		logger.info("veriySearchTime()");
		
		try {

			Boolean VerifyClickOnCustomer = comon.mouseoverEements(calculate.crmlink, calculate.customr);
			assrt.assertTrue(VerifyClickOnCustomer, "Customer link is not clickable under CRM");

			if (VerifyClickOnCustomer) {
				Boolean verifyTiming =	comon.CalculatePageLoadTime(calculate.srch, "A. Datta" , calculate.srchSuggestion, "Total time taken after search an organisation:-");
				assrt.assertTrue(verifyTiming, "Page not loading");
			} else {
				System.out.println("Customer Page is not opening on unfiy admin area");
			}


		} catch (Exception e) {
			e.getMessage();
			e.printStackTrace();
		}

		assrt.assertAll();

	}

	//@Test
	public void veriySearchTimeOnProductList(){
		try {

			Boolean VerifyClickOnCustomer = comon.mouseoverEements(calculate.prducts, calculate.srvcPlan);
			assrt.assertTrue(VerifyClickOnCustomer, "Customer link is not clickable under CRM");
			Thread.sleep(3000);

			if (VerifyClickOnCustomer) {
				Boolean verifyTiming =	calculate.CalculatePageLoadTime(calculate.list1st, calculate.list2nd, calculate.list);
				assrt.assertTrue(verifyTiming, "Page not loading");

			} else {
				System.out.println("Service plan data not loading on unfiy admin area");
			}


		} catch (Exception e) {
			e.getMessage();
			e.printStackTrace();
		}

		assrt.assertAll();

	}


	@AfterMethod
	public void tearDown(){
		driver.quit();
	}



}