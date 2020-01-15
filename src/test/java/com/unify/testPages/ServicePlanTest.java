package com.unify.testPages;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.unify.CommonsClass.CommonClass;
import com.unify.Pages.DashBoardPage;
import com.unify.Pages.LoginPage;
import com.unify.Pages.ServicePlanPage;
import com.unify.base.TestBase;
import com.unify.utill.CustomListner;

@Listeners(CustomListner.class)
public class ServicePlanTest extends TestBase{
	Logger logger = Logger.getLogger(ServicePlanTest.class);

	LoginPage loginPage;
	SoftAssert assrt;
	CommonClass comon;
	DashBoardPage dashboard;
	ServicePlanPage SpPage;


	public ServicePlanTest() {
		super();
	}


	@BeforeMethod
	public void setup(){
		loginPage = new LoginPage();
		comon = new CommonClass();
		assrt = new SoftAssert();
		SpPage = new ServicePlanPage();
		dashboard = loginPage.Login(prop.getProperty("username"), prop.getProperty("password"), prop.getProperty("domain"));

	}


	@Test
	public void veriyAddServicePlan() {
		logger.info("veriyAddServicePlan");
		try {

			assrt.assertTrue(comon.mouseoverEements(SpPage.prducts, SpPage.srvcPlan), "Service plan link is not working");

			String PageHeader = comon.GetAvailableText(SpPage.pageHeader);
			assrt.assertEquals(PageHeader, "Service Plan Manager");

			Thread.sleep(3000);

			Boolean clickOnAddServicePlan = comon.Openlinks(SpPage.addSrvcPlan);
			assrt.assertTrue(clickOnAddServicePlan, "Add service plan link not working");

			if (clickOnAddServicePlan) {

				assrt.assertTrue(comon.clickOnTwoWebElements(SpPage.planType, SpPage.postPaid), "Plan type are not able to select");

				assrt.assertTrue(comon.addValue(SpPage.plnID, "ServicePlan_001"), "Plan Id field is not working");

				assrt.assertTrue(comon.addValue(SpPage.discription, "SP_001"), "Plan Id field is not working");
				TimeUnit.SECONDS.sleep(3);
				assrt.assertTrue(comon.addValue(SpPage.billCycle, "1"), "Bill cycle field is not working");

				assrt.assertTrue(comon.clickOnTwoWebElements(SpPage.billPeriod, SpPage.slctBillPeriod), "Not able to click and select bill packet");

				Boolean VerifySaveButton = comon.Openlinks(SpPage.save);
				if (VerifySaveButton==true) {
					System.out.println("Service Plan added successfully");
				} else {
					System.out.println("After cliecking on save button service plan not created");
				}
				assrt.assertTrue(VerifySaveButton, "Save link not working for creating a service plan");
				
				
				TimeUnit.SECONDS.sleep(7);

				Boolean verfyServicePlan =   SpPage.vrfySerchPlanId("ServicePlan_001");
				assrt.assertTrue(verfyServicePlan, "Save and Search service plan field not working properly");
				System.out.println("Verify deleting process of service plan");
				
				if (verfyServicePlan) {

					assrt.assertTrue(comon.Openlinks(SpPage.slctSP), "Not able to select serched service plan");

					assrt.assertTrue(comon.Openlinks(SpPage.deleteSP), "Not able to click on delete button on serched service plan");

					assrt.assertTrue(comon.Openlinks(SpPage.deleteYes), "Not able to click on delete_yes on serched service plan");

				}
				
				else
				
				{
					System.out.println("Searched service plan link is not working");
				}

			}
			else
			{
				System.out.println("Add Service Plan page is not showing on webPage after clicking on Plus button");
			}





		} catch (Exception e) {
			e.getMessage();
			e.printStackTrace();
		}
		assrt.assertAll();

	}


	//@Test
	public void verifyLoadDataTime(){
		
		assrt.assertTrue(comon.mouseoverEements(SpPage.prducts, SpPage.srvcPlan), "Service plan link is not working");

		comon.CalculatePageLoadTime(SpPage.srvcPlan1);
		
		
		comon.CalculatePageLoadTime(SpPage.srchPlanID, "20Mbpsdemo", SpPage.verifyAddedSrchPlanID2, "Time taken to show service plan after search");
	}
	
	
	
	
	
	
	@AfterMethod
	public void tearDown(){
		
		driver.quit();
	}

}
