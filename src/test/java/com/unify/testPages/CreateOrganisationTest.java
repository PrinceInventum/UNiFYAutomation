package com.unify.testPages;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.unify.CommonsClass.CommonClass;
import com.unify.Pages.CreateOrganisation;
import com.unify.Pages.DashBoardPage;
import com.unify.Pages.LoginPage;
import com.unify.base.TestBase;
import com.unify.utill.CustomListner;
import com.unify.utill.Excel_Reader;



@Listeners(CustomListner.class)


public class CreateOrganisationTest extends TestBase{
	Logger logger = Logger.getLogger(CreateOrganisationTest.class);


	LoginPage loginPage;
	SoftAssert assrt;
	DashBoardPage dashboard;
	CommonClass comon;
	CreateOrganisation createOrg;
	Excel_Reader reder;

	public CreateOrganisationTest() {
		super();
	}


	@BeforeMethod
	public void setup(){
		loginPage = new LoginPage();
		createOrg = new CreateOrganisation();
		comon = new CommonClass();
		assrt = new SoftAssert();
		dashboard = loginPage.Login(prop.getProperty("username"), prop.getProperty("password"), prop.getProperty("domain"));
		reder	= new Excel_Reader("/home/princeambast/workspace/UnifySMP/src/main/java/com/unify/Testdata/TestDta.xlsx");
	}


	@Test
	public void veriyAddOrganisation() {
		logger.info("veriyAddOrganisation");
		try {

			Boolean VerifyClickOnCustomer = comon.mouseoverEements(createOrg.crmlink, createOrg.customr);
			assrt.assertTrue(VerifyClickOnCustomer, "Customer link is not clickable under CRM");


			String title =	driver.getTitle();
			System.out.println("CRM customer page heading is:" +" "+title);

			assrt.assertEquals(comon.GetAvailableText(createOrg.pageHeader), "Organisations & Contacts", "Page header text is not matching");


			Boolean verifyAddOrganisation = comon.Openlinks(createOrg.addOrg);

			assrt.assertTrue(verifyAddOrganisation , "Add organisation link is not working");

			if (verifyAddOrganisation)
			{
				assrt.assertTrue(createOrg.selectDomain(reder.getCellData("organisation", "Domain_Name", 2)),"Not able to search and add organisation name");

				String generated_ORG_Name = comon.dynamicSendkeys("Test_", createOrg.addOrgName);
				System.out.println("Added organisation name is : " + generated_ORG_Name);

				String generated_Sort_Name = comon.dynamicSendkeys("Test_", createOrg.shrtName);
				System.out.println("Added organisation short name : "+ generated_Sort_Name);

				createOrg.selectContract();

				assrt.assertTrue(comon.Openlinks(createOrg.lazerLink), "Link to lazer option not working");
				assrt.assertTrue(comon.Openlinks(createOrg.addLazerAccount), "adding lazer account is not working not working");				

				Boolean VerifyOrgFinishButton = comon.Openlinks(createOrg.fnshBtn);
				assrt.assertTrue(VerifyOrgFinishButton, "Finish button is not working");

				Boolean VerifyOrgFinalFinishButton = comon.Openlinks(createOrg.yesForShip);
				assrt.assertTrue(VerifyOrgFinalFinishButton, "Final Finish button is not working");


				if (VerifyOrgFinishButton==true) {


					Boolean verifySerchOrgField =comon.sendKeysData(createOrg.srchOrgFld, generated_Sort_Name, createOrg.srch);
					assrt.assertTrue(verifySerchOrgField, "Search organisation field not working properly");

					if (verifySerchOrgField) {

						Boolean verifySerchSuggestion =comon.Openlinks(createOrg.srchOrgFldDetls);
						assrt.assertTrue(verifySerchSuggestion, "Click on search result not working properly");

						Boolean verifySerchResults =comon.Openlinks(createOrg.srch);
						assrt.assertTrue(verifySerchResults, "Search link is not clickable");

						Thread.sleep(3000);

						String VerifyCurrentOrg_SortName =	comon.getAtributeValue(createOrg.orgSortName);
						assrt.assertEquals(VerifyCurrentOrg_SortName,generated_Sort_Name );

						Thread.sleep(3000);

						Boolean verifyServcTab =comon.Openlinks(createOrg.srvcTab);
						assrt.assertTrue(verifyServcTab, "Service tab is not clickable");

						Boolean verifyAddServc =comon.Openlinks(createOrg.addSrvc);
						assrt.assertTrue(verifyAddServc, " Add Service field is not clickable");

						Thread.sleep(3000);

						Boolean verifyServcGrp =comon.Openlinks(createOrg.srvcGrp);
						assrt.assertTrue(verifyServcGrp, " Service Group field is not showing");

						Thread.sleep(2000);

						String VerifyAddServcGrpHeading = comon.GetAvailableText(createOrg.addSrvcGrpHeading);
						assrt.assertEquals(VerifyAddServcGrpHeading, "Add Service Group" );

						if (VerifyAddServcGrpHeading!=null) {

							Boolean verifyAddServcGrpPageExpand =comon.Openlinks(createOrg.addSrvcGrpExpand);
							assrt.assertTrue(verifyAddServcGrpPageExpand, "Expand page button on add service group is not working");

							Thread.sleep(2000);

							Boolean verifyAddServcGrpPageReduce =comon.Openlinks(createOrg.addSrvcGrpReduce);
							assrt.assertTrue(verifyAddServcGrpPageReduce, "Expand page button on add service group is not working");

							Boolean verifyAddServcGrpPageCloseBtn =comon.Openlinks(createOrg.addSrvcGrpPageCrossBtn);
							assrt.assertTrue(verifyAddServcGrpPageCloseBtn, "Reduce page button on add service group is not working");

							Thread.sleep(2000);

							Boolean verifyAddServcAgain =comon.Openlinks(createOrg.addSrvc);
							assrt.assertTrue(verifyAddServcAgain, " Add Service field is not clickable after clicking cross button");

							Thread.sleep(3000);

							Boolean verifyServcGrpAgain =comon.Openlinks(createOrg.srvcGrp);
							assrt.assertTrue(verifyServcGrpAgain, " Service Group field is not showing after clicking cross button");

							String addServiceGrpPageDetails = comon.GetAvailableText(createOrg.addSrvcGrpPopUpDetails);
							if (addServiceGrpPageDetails!=null) {

								Boolean verifyUniqueIDCheckBox =comon.Openlinks(createOrg.uniqueIdCheckBox);
								assrt.assertTrue(verifyUniqueIDCheckBox, "Unique Id Check Box Not Working");	

								String VerifyUniqueIdCheckBox =	comon.GetAvailableText(createOrg.uniqueIdCheckBoxText);
								assrt.assertEquals(VerifyUniqueIdCheckBox,"Generate (Unique ID)" );

								String VerifyUniqueIdValue = comon.getAtributeValue(createOrg.uniqueIDValue);
								logger.info("Added Unique Id Is: " + VerifyUniqueIdValue);

								Thread.sleep(1000);

								Boolean VerifyServiceType = comon.clickOnTwoWebElements(createOrg.orgTypeV, createOrg.billType);
								assrt.assertTrue(VerifyServiceType, "Bill type not able add");

								Boolean verifyAddDomain =comon.sendKeysData(createOrg.domainName, "Inventum", createOrg.domainNameValue);
								assrt.assertTrue(verifyAddDomain, "Domain value fields are not working");

								Thread.sleep(2000);

								Boolean BillToTypeXpath = comon.clickOnTwoWebElements(createOrg.billToContact, createOrg.billToContactTypes);
								assrt.assertTrue(BillToTypeXpath, "Bill to contact field not working");

								Boolean VerifySrvcGrp = comon.Openlinks(createOrg.saveSrvcGrp);
								assrt.assertTrue(VerifySrvcGrp, "Bill to contact field not working");

								if (VerifySrvcGrp) {
								
									Thread.sleep(2000);

									Boolean verifyBillSetupOnSrvcGrpCheckBox = comon.Openlinks(createOrg.CreatedSrvcBox);
									assrt.assertTrue(verifyBillSetupOnSrvcGrpCheckBox, "Service group check box is not working");

									Thread.sleep(1000);

									Boolean verifyRightClickOnSrvcGrp = comon.rightClickOnElements(createOrg.CreatedSrvcBox);
									assrt.assertTrue(verifyRightClickOnSrvcGrp, "Right click on service group not working");

									Thread.sleep(3000);

									Boolean verifyBillSetupOption = comon.Openlinks(createOrg.billSetup);
									assrt.assertTrue(verifyBillSetupOption, "Bill setup link is not clickable");

									Thread.sleep(2000);

									if (verifyBillSetupOption) {

										String VerifyBillSetupHeader= comon.GetAvailableText(createOrg.billSetupHeader);
										assrt.assertEquals(VerifyBillSetupHeader, "Add Bill Setup");

										Boolean VerifyBillfrequncy = createOrg.addBillFrequency(createOrg.billFrquncy, "1");
										assrt.assertTrue(VerifyBillfrequncy, "Not able to add bill frequency");

										Boolean VerifyBillFrequencyPeriod = comon.clickOnTwoWebElements(createOrg.billFrquncyDropDown, createOrg.billFrquncyPeriod);
										assrt.assertTrue(VerifyBillFrequencyPeriod, "Not able to add Bill frequency Period");

										Boolean VerifyBillCycle = comon.clickOnTwoWebElements(createOrg.billFrquncyCycle, createOrg.selectBillFrquncyCycle);
										assrt.assertTrue(VerifyBillCycle, "Not able to select Bill frequency Cycle");
										
										Thread.sleep(1000);
										
										Boolean VerifyInvoiceTemplate = comon.clickOnTwoWebElements(createOrg.invcTemplte, createOrg.invcTemplteValue);
										assrt.assertTrue(VerifyInvoiceTemplate, "Not able to select Invoice Template");
										
										Thread.sleep(1000);
										
										Boolean VerifyBillRunProfile = comon.clickOnTwoWebElements(createOrg.billRun, createOrg.billRunValue);
										assrt.assertTrue(VerifyBillRunProfile, "Not able to select Bill run profile");

										Boolean verifyFutureInvoice = comon.Openlinks(createOrg.futureInvoice);
										assrt.assertTrue(verifyFutureInvoice, "Future invoice field is not clickble");
										
										Thread.sleep(2000);
										
										Boolean verifyBllSetupSaveBtn = comon.Openlinks(createOrg.saveBtn);
										assrt.assertTrue(verifyBllSetupSaveBtn, "Bill run profile save button not working");

									} else {
										logger.info("Bill Setup Profile Page not working");
									}

									Boolean VerifyAddSubscription = comon.Openlinks(createOrg.addSubscrption);
									assrt.assertTrue(VerifyAddSubscription, "Add subscription link not clickable");

									if (VerifyAddSubscription) {

										Boolean VerifySubscription = comon.Openlinks(createOrg.addSubscrptionResult);
										assrt.assertTrue(VerifySubscription, "Subscription link not clicable");

										comon.GetAvailableText(createOrg.srvcPlnDetailsList);

										Thread.sleep(1000);

										Boolean VerifyRatePlan = comon.clickOnTwoWebElements(createOrg.ratePlan, createOrg.ratePlanDropDown);
										assrt.assertTrue(VerifyRatePlan, "Not able to add rate plan from drop down");

										Thread.sleep(3000);

										Boolean VerifyRC = comon.Openlinks(createOrg.ratePlanRC);
										assrt.assertTrue(VerifyRC, "RC field is not clickable");

										Boolean VerifyRCTaxPlan = comon.Openlinks(createOrg.tax);
										assrt.assertTrue(VerifyRCTaxPlan, "Tax plan for RC field is not clickable");

										Boolean VerifyRCTaxClasses = comon.clickOnTwoWebElements(createOrg.taxDropDown, createOrg.taxDropDownValue);
										assrt.assertTrue(VerifyRCTaxClasses, "Not able to add tax plan");

										Thread.sleep(3000);

										Boolean VerifyNRC = comon.Openlinks(createOrg.ratePlanNRC);
										assrt.assertTrue(VerifyNRC, "NRC field is not clickable");

										Boolean VerifyNRCTaxPlan = comon.Openlinks(createOrg.nrcTax);
										assrt.assertTrue(VerifyNRCTaxPlan, "NRC Tax plan field is not clickable");

										Boolean VerifyNRCTaxClasses = comon.clickOnTwoWebElements(createOrg.taxNRCDropDown, createOrg.taxNRCDropDownValue);
										assrt.assertTrue(VerifyNRCTaxClasses, "Not able to add tax plan");

										Boolean VerifySaveBtnSubscription = comon.Openlinks(createOrg.servcPlanSave);
										assrt.assertTrue(VerifySaveBtnSubscription, "Save button not working on subscription field");


									} else {
										logger.info("Add Subscription link not working");
									}
									
									Thread.sleep(3000);
									
									Boolean VerifyGenerateInvoice = comon.Openlinks(createOrg.invoice);
									assrt.assertTrue(VerifyGenerateInvoice, "Invoice button is not clickable");

									if (VerifyGenerateInvoice) {

										Boolean VerifyRunInvoiceLink = comon.Openlinks(createOrg.runInvoice);
										assrt.assertTrue(VerifyRunInvoiceLink, "Run Invoice link is not working");
										
										Boolean VerifyRunInvoiceDate = comon.Openlinks(createOrg.InvoiceDate);
										assrt.assertTrue(VerifyRunInvoiceDate, "Run Invoice date link is not working");
										
										Boolean VerifyRunInvoiceTodayDate = comon.Openlinks(createOrg.InvoideDatePicker);
										assrt.assertTrue(VerifyRunInvoiceTodayDate, "Today Invoice date link is not working");
										
										Boolean VerifyTrialInvoice = comon.Openlinks(createOrg.trailInvoice);
										assrt.assertTrue(VerifyTrialInvoice, "Today Invoice date link is not working");
										
										Thread.sleep(2000);
										
										Boolean VerifyRunTrialInvoice = comon.Openlinks(createOrg.runTrailInvoice);
										assrt.assertTrue(VerifyRunTrialInvoice, "Run trail invoice link is not working");
										
										Thread.sleep(2000);
										
										Boolean VerifyInvoiceHTMLView = comon.Openlinks(createOrg.viewInvoice);
										assrt.assertTrue(VerifyInvoiceHTMLView, "View Invoice as HTML not working");
										
										if (VerifyInvoiceHTMLView) {
											System.out.println("Invoice Generated Successfully");
										}
										
									} else {
										logger.info("Invoice button is not clickable");
									}


								} else {
									logger.info("Not able to add service group");
								}

							} else {
								logger.info("Add service group detais not showing");
							}

						} else {
							logger.info("Add Service group fields are not visible");
						}





					} else {
						logger.info("Search organisation field not working");
					}


				} else {
					logger.info("Finish button not working properly");
				}


			}
			else
			{
				System.out.println("Add organisation fields are not displaying");
			}

			Thread.sleep(2000);

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