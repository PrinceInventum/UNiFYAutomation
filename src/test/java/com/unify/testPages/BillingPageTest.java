package com.unify.testPages;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.unify.CommonsClass.CommonClass;
import com.unify.Pages.BillingPage;
import com.unify.Pages.DashBoardPage;
import com.unify.Pages.LoginPage;
import com.unify.base.TestBase;
import com.unify.utill.Excel_Reader;

public class BillingPageTest extends TestBase{

	LoginPage loginPage;
	SoftAssert assrt;
	DashBoardPage dashboard;
	CommonClass comon;
	Excel_Reader reder;
	BillingPage billP;

	public BillingPageTest() {
		super();
	}


	@BeforeMethod
	public void setup(){
		loginPage = new LoginPage();
		comon = new CommonClass();
		assrt = new SoftAssert();
		billP = new BillingPage();
		dashboard = loginPage.Login(prop.getProperty("username"), prop.getProperty("password"), prop.getProperty("domain"));
		reder	= new Excel_Reader("/home/princeambast/workspace/UnifySMP/src/main/java/com/unify/Testdata/TestDta.xlsx");
	}




	@Test
	public void VerifyRC_Charges()
	{

		try {

			System.out.println("Veriy Recurring Charges");

			Boolean VerifyClickOnBilling = comon.mouseoverEements(billP.BillingLink, billP.BillingCharge);
			assrt.assertTrue(VerifyClickOnBilling, "Charges link is not clickable under Billing");


			String title =	driver.getTitle();
			System.out.println("Billing charges page heading is:" +" "+title);

			assrt.assertEquals(title, "Charges", "Page Title text is not matching");

			Boolean VerifyClickOnRC = comon.Openlinks(billP.RcChrges);
			assrt.assertTrue(VerifyClickOnRC, "RC link is not clickable");

			if (VerifyClickOnRC) {

				Boolean VerifyClickOnAddRc = comon.Openlinks(billP.addRcBtn);
				assrt.assertTrue(VerifyClickOnAddRc, "Charges link is not clickable under Billing");
				
				assrt.assertTrue(comon.addValue(billP.rcId,prop.getProperty("RC_ID")),"Not able to add RC ");
				
				assrt.assertTrue(comon.addValue(billP.rcName,prop.getProperty("RC_ID")),"Not able to add RC Description");
			
				
				
			} else {
				System.out.println("Add RC Button not present");
			}









			





		} catch (Exception e) {
			e.printStackTrace();
		}
		assrt.assertAll();
	}



}
