package com.unify.testPages;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.unify.CommonsClass.CommonClass;
import com.unify.Pages.DashBoardPage;
import com.unify.Pages.DomainManager;
import com.unify.Pages.LoginPage;
import com.unify.base.TestBase;

public class DomainManagerTest extends TestBase{

	Logger logger = Logger.getLogger(DomainManagerTest.class);

	LoginPage loginPage;
	SoftAssert assrt;
	DashBoardPage dashboard;
	CommonClass comon;
	DomainManager dManager;
	public DomainManagerTest() {
		super();
	}


	@BeforeMethod
	public void setup(){
		loginPage = new LoginPage();
		comon = new CommonClass();
		assrt = new SoftAssert();
		dManager = new DomainManager();
		dashboard = loginPage.Login(prop.getProperty("username"), prop.getProperty("password"), prop.getProperty("domain"));

	}


	@Test
	public void veriyDomainManager(){
		logger.info("veriyDomainManager");

		try {
			Thread.sleep(3000);

			Boolean VerifyClickOnDomainManager = comon.mouseoverEements(dManager.domainLink, dManager.domainManager);
			assrt.assertTrue(VerifyClickOnDomainManager, "Domain manager link is not working");

			comon.Openlinks(dManager.nxc);
			
			Thread.sleep(3000);

			assrt.assertTrue(CommonClass.getListofLink(dManager.firstlink, dManager.allelmnts), "Created domain not showing on webpage");

		} catch (Exception e) {
			e.getMessage();
			e.printStackTrace();
		}

		assrt.assertAll();

	}


	@Test
	public void VerifyParentDomainText() {
		logger.info("VerifyDmainText");

		try {
			Thread.sleep(2000);

			Boolean VerifyClickOnDomainManager = comon.mouseoverEements(dManager.domainLink, dManager.domainManager);
			assrt.assertTrue(VerifyClickOnDomainManager, "Domain manager link is not working");

			Boolean verifyDomain =	comon.Openlinks(dManager.parentDomain);
			assrt.assertTrue(verifyDomain, "Parent domain link is not working");

			String verifyTextAfterClickingOnParentDomain = comon.GetAvailableText(dManager.unqueId);
			assrt.assertEquals(verifyTextAfterClickingOnParentDomain, "Unique ID:*");

			if (verifyTextAfterClickingOnParentDomain!=null) {
				System.out.println("\n"+"Parent domain opens");
			} else {
				System.out.println("Parent domain link not working");
			}

			String VerifyUniqueIDAtributeValue = dManager.unqueIdName.getAttribute("value");
			System.out.println("\n"+"Added Unique ID : "+VerifyUniqueIDAtributeValue);
			assrt.assertEquals(VerifyUniqueIDAtributeValue, "admin");

			String verifyDomainNameText = comon.GetAvailableText(dManager.domainName);
			assrt.assertEquals(verifyDomainNameText, "Domain Name:*");

			String VerifyDomainNameAtributeValue = dManager.domainNameAtribute.getAttribute("value");
			System.out.println("\n"+"Added Domain Name: "+VerifyDomainNameAtributeValue);
			assrt.assertEquals(VerifyDomainNameAtributeValue, "SSG Admin");

			Boolean VerifyContactDetailsTabList =	CommonClass.getListofLink(dManager.contactDetails, dManager.contactDetailsTablist);
			assrt.assertNotNull(VerifyContactDetailsTabList);

			if (VerifyContactDetailsTabList=true) {

				Boolean VerifyAddRow = comon.Openlinks(dManager.addRow);	
				assrt.assertTrue(VerifyAddRow, "Add Row link is not clickable under Contact details");

				Boolean VerifyContactTypeDropDown = comon.Openlinks(dManager.contactType);	
				assrt.assertTrue(VerifyContactTypeDropDown, "Contact type drop down is not clickable");
				if (VerifyContactTypeDropDown=true) {

					Boolean VerifyContactTypeList = comon.isPagedisplaying(dManager.contactTypeList);
					assrt.assertNotNull(VerifyContactTypeList, "Contact type list are not showing");

					Boolean TypeOnContactList = comon.Openlinks(dManager.contactTypeAdmns);
					assrt.assertTrue(TypeOnContactList, "Administrative link is not clickable");

				}

				Boolean VerifyFirstNameField = comon.Openlinks(dManager.frstNameField);	
				assrt.assertTrue(VerifyFirstNameField, "First name field under contact details are not showing");

				if (VerifyFirstNameField) {
					Boolean VerifyAddFirstName = comon.addValue(dManager.frstName, "Test");
					assrt.assertTrue(VerifyAddFirstName, "User not able to Add First name");
				}else {
					logger.info("First name fields are not showing");
				}

				Boolean VerifyLastNameField = comon.Openlinks(dManager.lastNameField);	
				assrt.assertTrue(VerifyLastNameField, "Last name field under contact details are not showing");

				if (VerifyLastNameField) {
					Boolean VerifyAddLastName = comon.addValue(dManager.lstName, "Domain");
					assrt.assertTrue(VerifyAddLastName, "User not able to Add last name");


				}else {
					logger.info("Last name fields are not showing");
				}


				Boolean VerifyContryField = comon.Openlinks(dManager.cntry);	
				assrt.assertTrue(VerifyContryField, "Country field under contact details are not showing");

				if (VerifyContryField) {

					Boolean verifyCountryText =	dManager.countryField();
					assrt.assertTrue(verifyCountryText, "Not able to add country name");

				}else {
					logger.info("Country fields are not working");
				}

				Boolean VerifyCityField = comon.Openlinks(dManager.city);	
				assrt.assertTrue(VerifyCityField, "City  field under contact details are not showing");

				if (VerifyCityField) {

					Boolean verifyCityText = dManager.cityField();
					assrt.assertTrue(verifyCityText, "Not able to add city name");

				}else {
					logger.info("city fields are not working");
				}


			} else {
				logger.info("Contact list fields are not showing");
			}

		} catch (Exception e) {
			e.getMessage();
			e.printStackTrace();
		}
		assrt.assertAll();
	}


	@Test
	public void VerifyWelcomeLinks(){

		Boolean VerifyClickOnDomainManager = comon.mouseoverEements(dManager.domainLink, dManager.domainManager);
		assrt.assertTrue(VerifyClickOnDomainManager, "Domain manager link is not working");

		Boolean verifyAllElements = comon.isPagedisplaying(dManager.domnTab);
		assrt.assertTrue(verifyAllElements);	
		assrt.assertAll();
	}


	@Test
	public void VerifyNextraDomain()
	{
		Boolean VerifyClickOnDomainManager = comon.mouseoverEements(dManager.domainLink, dManager.domainManager);
		assrt.assertTrue(VerifyClickOnDomainManager, "Domain manager link is not working");

		Boolean nextraDomain =  comon.Openlinks(dManager.nextraDomain);
		assrt.assertTrue(nextraDomain, "Nextra domain is not clickable");

		String verifyTextAfterClickingOnParentDomain = comon.GetAvailableText(dManager.unqueId);
		assrt.assertEquals(verifyTextAfterClickingOnParentDomain, "Unique ID:*");

		if (verifyTextAfterClickingOnParentDomain!=null) {
			System.out.println("\n"+"Nextra domain opens");
		} else {
			System.out.println("Nextra domain link not working");
		}

		String VerifyUniqueIDAtributeValue = dManager.unqueIdName.getAttribute("value");
		System.out.println("\n"+"Added Unique ID : "+VerifyUniqueIDAtributeValue);
		assrt.assertEquals(VerifyUniqueIDAtributeValue, "Nextra");

		String verifyDomainNameText = comon.GetAvailableText(dManager.domainName);
		assrt.assertEquals(verifyDomainNameText, "Domain Name:*");

		String VerifyDomainNameAtributeValue = dManager.domainNameAtribute.getAttribute("value");
		System.out.println("\n"+"Added Domain Name: "+VerifyDomainNameAtributeValue);
		assrt.assertEquals(VerifyDomainNameAtributeValue, "Nextra");

		String verifyParentDomainText = comon.GetAvailableText(dManager.parentDmain);
		assrt.assertEquals(verifyParentDomainText, "Parent Domain:");

		String VerifyParentDomainAtributeValue = dManager.parentDomainNameAtribute.getAttribute("value");
		System.out.println("\n"+"Parent domain is: "+VerifyParentDomainAtributeValue);
		assrt.assertEquals(VerifyParentDomainAtributeValue, "SSG Admin (admin)");

		Boolean verifyNextraDetails = comon.isPagedisplaying(dManager.NextraDetails);
		assrt.assertNotNull(verifyNextraDetails);



	}


	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}