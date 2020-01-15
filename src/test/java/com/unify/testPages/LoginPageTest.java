package com.unify.testPages;


import org.apache.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

import com.unify.CommonsClass.CommonClass;
import com.unify.Pages.DashBoardPage;
import com.unify.Pages.LoginPage;
import com.unify.base.TestBase;


public class LoginPageTest extends TestBase {

	Logger logger = Logger.getLogger(LoginPageTest.class);

	LoginPage loginPage;
	SoftAssert assrt;
	DashBoardPage dashboard;
	CommonClass comn;

	public LoginPageTest() {
		super();
	}


	@BeforeMethod
	public void setup(){
		loginPage = new LoginPage();
		comn = new CommonClass();
		assrt = new SoftAssert();
	}






	@Test
	public void verifyLogin(){
		logger.info("Verify Valid Login Details");
		String title =	driver.getTitle();

		logger.info("\n"+"Home page Title is:" +" "+title);
		assrt.assertEquals("Unify Login", title);


		dashboard = loginPage.Login(prop.getProperty("username"), prop.getProperty("password"), prop.getProperty("domain"));
		String title1 =	driver.getTitle();
		System.out.println("\n"+"After login page Title is:" +" "+title1);

		if (title1!=null) {
			System.out.println("\n"+"Login successfull");
		} else {
			System.out.println("\n"+"Facing some issue on login");
		}
		assrt.assertEquals("Desktop", title1);
		assrt.assertAll();
	}



	@Test
	public void verifyiNVALIDLogin(){
		logger.info("Verify Invalid Login Details");

		try {
			String title =	driver.getTitle();
			logger.info("\n"+"Home page Title is:" +" "+title);

			dashboard = loginPage.Login(prop.getProperty("usernameInvalid"), prop.getProperty("passwordInvalid"), prop.getProperty("domain"));

			String verifyTermsandConditionHeader = comn.GetAvailableText(loginPage.trmsCondtionAlert);

			assrt.assertEquals(verifyTermsandConditionHeader, "Terms & Conditions");

			if (verifyTermsandConditionHeader!=null) {


				String verifyTermsandConditionText = comn.GetAvailableText(loginPage.trmsCondtionText);

				if (verifyTermsandConditionText!=null) {
					System.out.println("\n"+"Terms and condition text are showing");

				} else {
					System.out.println("\n"+"Terms and condition text are not showing");
				}

				Boolean verifyCrossButton =  comn.Openlinks(loginPage.trmsCondtionAlertCrossBtn);

				if (verifyCrossButton) {

					assrt.assertTrue(comn.Openlinks(loginPage.submt), "On login page submit button is not clickable when I close the terms and condition alert");

				}
				assrt.assertTrue(verifyCrossButton, "Cross button is not clickable on Terms and condition popup");



				Boolean verifyAgreement = comn.Openlinks(loginPage.trmsCondtionAgrmnt);
				assrt.assertTrue(verifyAgreement, "Agrement field is not clickable");

				Boolean verifyAgreementCheckBox = loginPage.isAgreementSelected();
				assrt.assertTrue(verifyAgreementCheckBox, "Agreement checkbox is not working properly");

				Boolean verifyDenyFunctionality = comn.Openlinks(loginPage.deny);
				assrt.assertTrue(verifyDenyFunctionality, "\n"+"Agreement checkbox is not working properly");

				if (verifyDenyFunctionality) {

					assrt.assertEquals(comn.GetAvailableText(loginPage.denyAlert), "MESSAGE", "Not showing correct alert header");
					assrt.assertEquals(comn.GetAvailableText(loginPage.denyAlertMsg), "Please accept the Terms and Conditions to proceed","Not showing correct Alert message");
					assrt.assertTrue(comn.Openlinks(loginPage.denyAlertOk), "Ok button not working on terms and condition deny alert");

					assrt.assertTrue(comn.Openlinks(loginPage.submt), "On login page submit button is not clickable when I click on deny alert");


				} else {
					System.out.println("\n"+"Deny functionality is not working properly on Terms and condition field");
				}

				assrt.assertTrue(comn.Openlinks(loginPage.accept), "Accept button not working on Terms and condition");

				Thread.sleep(3000);

				assrt.assertEquals(comn.GetAvailableText(loginPage.invalidLoginMsg), "Invalid Credentials Provided.");

			}
			else
			{
				System.out.println("\n"+"Terms and condition POPUP is not showing");
			}


		} catch (Exception e) {
			e.printStackTrace();
			e.getMessage();
		}


		assrt.assertAll();
	}


	@Test
	public void verifyTextOnLoginPage(){
		logger.info("verifyTextOnLoginPage");
		logger.info("Test Case: Verify all Text on login field");

		assrt.assertEquals(comn.GetAvailableText(loginPage.loginheder), "Admin Portal");
		assrt.assertEquals(comn.GetAvailableText(loginPage.un), "User Name");
		assrt.assertEquals(comn.GetAvailableText(loginPage.pw), "Password");
		assrt.assertEquals(comn.GetAvailableText(loginPage.dman), "Domain");

		assrt.assertTrue(comn.Openlinks(loginPage.remembr), "Remember link is not clickable");

		Boolean verifyRememberMeField = loginPage.isRememberMeSelected();
		assrt.assertTrue(verifyRememberMeField, "Rememeber me link not working properly");

		assrt.assertEquals(comn.GetAvailableText(loginPage.stayLogn), "Stay logged in");

		assrt.assertAll();
	}




	@Test

	public void verifyLogOut()
	{
		logger.info("verifyLogOut");
		dashboard = loginPage.Login(prop.getProperty("username"), prop.getProperty("password"), prop.getProperty("domain"));
		assrt.assertEquals("Desktop", driver.getTitle());


		Boolean verifyLogOut = comn.Openlinks(loginPage.logout);
		assrt.assertTrue(verifyLogOut, "Logout link is not working");

		
		if (verifyLogOut) {

			System.out.println("clicked on logout link and logout PopUp is showing on WebPage");

			assrt.assertEquals(comn.GetAvailableText(loginPage.logoutHeader), "LOGOUT");

			assrt.assertEquals(comn.GetAvailableText(loginPage.logoutText), "Are you sure you want to logout?");

			assrt.assertTrue(comn.Openlinks(loginPage.logoutCrossButton), "Logout cross button button not working");

			assrt.assertTrue(comn.Openlinks(loginPage.logout), "Logout link is not working after clicking on cross button");

			assrt.assertTrue(comn.Openlinks(loginPage.logoutCancel), "Logout cancel button not working");

			assrt.assertTrue(comn.Openlinks(loginPage.logout), "Logout link is not working after clicking on cancel button");

			assrt.assertTrue(comn.Openlinks(loginPage.logoutOk), "Logout OK button not working");

			
			
		} else {
			System.out.println("LogOut popup not showing");
		}
		assrt.assertAll();
	}





	@AfterMethod
	public void tearDown(){
		driver.quit();
	}



}
