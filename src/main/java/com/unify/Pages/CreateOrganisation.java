package com.unify.Pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.unify.base.TestBase;

public class CreateOrganisation extends TestBase {
	 
	Logger logger = Logger.getLogger(CreateOrganisation.class);
	
	@FindBy(xpath="//a[@class='NavLink' and text()= 'CRM']")
	public WebElement crmlink;

	@FindBy(xpath="//a[@class='PopupLinks' and text()= 'Customers']")
	public WebElement customr;

	@FindBy(id="crmTopPanel_header_hd-textEl")
	public WebElement pageHeader;

	@FindBy(id="orgAddBtnId-btnIconEl")
	public WebElement addOrg;

	@FindBy(xpath="//td[@id='combobox-1483-inputCell']/following-sibling::td[1]")
	public WebElement slctDomain;
	
	@FindBy(name="domain.domno")
	public WebElement srchDomain;
	
	@FindBy(xpath="//*[contains(@class,'x-boundlist-item')]")
	public WebElement srchDomainName;

	@FindBy(id="orgName-inputEl")
	public WebElement addOrgName;

	@FindBy(id="shortName-inputEl")
	public WebElement shrtName;

	@FindBy(xpath="//td[@id='contactTypeid-inputCell']/following-sibling::td[1]/div[1]")
	public WebElement cntrctList;

	@FindBy(xpath="//li[@class='x-boundlist-item' and text()='Bill To']")
	public WebElement cntrctListBillTo;

	@FindBy(id="move-next-btnIconEl")
	public WebElement lazerLink;

	@FindBy(id="newLedgerAccount-inputEl")
	public WebElement addLazerAccount;
	
	@FindBy(id="finish-btnIconEl")
	public WebElement fnshBtn;
	
	@FindBy(id="button-1006-btnIconEl")
	public WebElement yesForShip;
	
	@FindBy(id="button-1006-btnIconEl")
	public WebElement confrmationReport;
	
	@FindBy(id="topSearchId-inputEl")
	public WebElement srchOrgFld;
	
	@FindBy(xpath="//*[@class='list-icon']/following-sibling::span[1]")
	public WebElement srchOrgFldDetls;
	
	@FindBy(xpath="//div[@class='x-trigger-index-1 x-form-trigger x-form-search-trigger']")
	public WebElement srch;
	
	@FindBy(name="organisation.shortName")
	public WebElement orgSortName;
	
	@FindBy(xpath="//*[@class='x-tab-inner x-tab-inner-center' and text()='Services']")
	public WebElement srvcTab;
	
	@FindBy(id="addButton-btnIconEl")
	public WebElement addSrvc;
	
	@FindBy(xpath="//span[@class='x-menu-item-text' and text()='Service Group']")
	public WebElement srvcGrp;
		
	@FindBy(xpath="//*[contains(@class,'x-header-text x-w') and text()='Add Service Group']")
	public WebElement addSrvcGrpHeading;
	
	@FindBy(xpath="//*[@class='x-tool-img x-tool-maximize']")
	public WebElement addSrvcGrpExpand;
	
	@FindBy(xpath="//*[@class='x-tool-img x-tool-restore']")
	public WebElement addSrvcGrpReduce;
	
	@FindBy(xpath="//*[@id='crmTopPanel']/following-sibling::div[21]/div[1]/div[1]/div[1]/div[1]/div[4]/img[1]")
	public WebElement addSrvcGrpPageCrossBtn;
	
	@FindBy(id="addserviceGroupForm-innerCt")
	public WebElement addSrvcGrpPopUpDetails;
	
	@FindBy(xpath="//*[contains(@class,'x-field x-table-plain x-form-item x-form-type-checkbox x-b')]/tbody[1]/tr[1]/td[2]/input[1]")
	public WebElement uniqueIdCheckBox;
	
	@FindBy(xpath="//*[@class='x-form-cb-label x-form-cb-label-after' and text()='Generate (Unique ID)']")
	public WebElement uniqueIdCheckBoxText;
	
	@FindBy(xpath="//*[@id='groupCatid-inputCell']/following-sibling::td[1]/div[1]")
	public WebElement orgType;
	
	@FindBy(id="groupCatid-inputCell")
	public WebElement orgTypeV;
	
	@FindBy(xpath="//div[contains(@class,'x-panel x-layer x-panel-default')]/following-sibling::div[3]/div[1]/ul/li[1]")
	public WebElement billType;
	
	@FindBy(name="account.actid")
	public WebElement uniqueIDValue;
	
	@FindBy(name="account.domno")
	public WebElement domainName;
	
	@FindBy(xpath="//div[contains(@class,'x-panel x-layer x-panel-default')]/following-sibling::div[4]/div[1]/ul[1]/li[1]")
	public WebElement domainNameValue;
	
	@FindBy(xpath="//*[@name='account.billToContact']/parent::td[1]/following-sibling::td[1]/div[1]")
	public WebElement billToContact;
	
	@FindBy(xpath="//div[contains(@class,'x-panel x-layer x-panel-default')]/following-sibling::div[7]/div[1]/div[2]")
	public WebElement billToContactTypes;

	@FindBy(id="saveServiceGroupId-btnIconEl")
	public WebElement srvcGrpSave;

	@FindBy(xpath="//span[@class='x-btn-inner x-btn-inner-center' and text()='Cancel']")
	public WebElement srvcGrpCancel;
	
	@FindBy(id="saveServiceGroupId-btnIconEl")
	public WebElement saveSrvcGrp;
	
	@FindBy(xpath="//*[@class='x-grid-row x-grid-data-row']/td[2]/div[1]")
	public WebElement CreatedSrvc;
	
	@FindBy(xpath="//*[@id='serviceGroupListPanel-body']/div[1]/table[1]/tbody[1]/tr[1]/td[2]/div[1]")
	public WebElement CreatedSrvcBox;
	
	@FindBy(xpath="//*[@class='x-menu-item-icon add-icon ']")
	public WebElement billSetup;
	
	@FindBy(xpath="//*[@class='x-header-text x-window-header-text x-window-header-text-default' and text()='Add Bill Setup']")
	public WebElement billSetupHeader;
	
	@FindBy(xpath="//*[@id='billingDuration-inputEl']")
	public WebElement billFrquncy;
	
	@FindBy(xpath="//*[@id='BillingCycleId-inputCell']/following-sibling::td[1]/div")
	public WebElement billFrquncyDropDown;
	
	@FindBy(xpath="//*[@class='x-boundlist-item' and text()='Months']")
	public WebElement billFrquncyPeriod;
	
	@FindBy(xpath="//*[@id='invoiceDayBillCycle-inputCell']/following-sibling::td[1]/div")
	public WebElement billFrquncyCycle;
	
	@FindBy(xpath="//*[@class='x-boundlist-item' and text()='Monthly 01st of Month']")
	public WebElement selectBillFrquncyCycle;
	
	@FindBy(xpath="//*[@name='billSetUp.invoiceTemplateNo']/parent::td[1]/following-sibling::td[1]/div")
	public WebElement invcTemplte;
	
	@FindBy(xpath="//*[@id='ext-quicktips-tip']/following-sibling::div[26]/div/ul/li[1]")
	public WebElement invcTemplteValue;
	
	@FindBy(xpath="//*[@name='billSetUp.billProfileNo']/parent::td[1]/following-sibling::td[1]/div")
	public WebElement billRun;
	
	@FindBy(xpath="//*[@id='ext-quicktips-tip']/following-sibling::div[30]/div/ul/li[1]")
	public WebElement billRunValue;
	
	@FindBy(xpath="//*[@id='billSetUpID-inputEl']")
	public WebElement futureInvoice;
	
	@FindBy(xpath="//*[@id='addbillSetupForm-body']/following-sibling::div[1]/div[1]/div[1]/a[1]/span[1]/span[1]/span[2]")
	public WebElement saveBtn;
	
	@FindBy(id="subsAddMenu-btnIconEl")
	public WebElement addSubscrption;
	
	@FindBy(xpath="//*[@class='x-menu-item-text' and text()='Subscription']")
	public WebElement addSubscrptionResult;
	
	@FindBy(id="subsForm-innerCt")
	public WebElement srvcPlnDetailsList;
	
	@FindBy(xpath="//*[@id='rateplanId-inputCell']/following-sibling::td[1]/div")
	public WebElement ratePlan;
	
	@FindBy(xpath="//*[@id='addSubsForm']/following-sibling::div[1]/div/div[2]/span")
	public WebElement ratePlanDropDown;
	
	@FindBy(xpath="//*[@id='subsForm-innerCt']/div[2]/div[1]/div[1]/div[2]/div[1]/a[3]/span/span/span[2]")
	public WebElement ratePlanRC;
	
	@FindBy(xpath="//*[@id='subsForm-innerCt']/div[2]/div[1]/div[1]/div[2]/div[1]/a[4]/span/span/span[2]")
	public WebElement ratePlanNRC;
	
	@FindBy(xpath="//*[@id='subsFormRCGrid-body']/div/table/tbody/tr/td[3]/div")
	public WebElement ratePlanQuantity;
	
	@FindBy(xpath="//*[@id='subsFormrateclassid-inputCell']/following-sibling::td[1]/div")
	public WebElement ratePlanQuantityDropDown;
	
	@FindBy(xpath="//*[@id='subsFormRCGrid-body']/div/table/tbody/tr/td[8]/div")
	public WebElement tax;
	
	@FindBy(xpath="//*[@id='subsFormBNRCGridID-body']/div/table/tbody/tr/td[10]/div")
	public WebElement nrcTax;
	
	@FindBy(xpath="//*[@id='subsFormRCGrid-body']/following-sibling::div[1]/table/tbody/tr/td[2]/table/tbody/tr/td[2]/div")
	public WebElement taxDropDown;
	
	@FindBy(xpath="//*[@id='addSubsForm-southwest-handle']/parent::div[1]/following-sibling::div[4]/div/ul")
	public WebElement taxDropDownValue;
	
	@FindBy(xpath="//*[@id='subsFormBNRCGridID-body']/following-sibling::div[1]/table/tbody/tr/td[2]/table/tbody/tr/td[2]/div")
	public WebElement taxNRCDropDown;
	
	@FindBy(xpath="//*[@id='addSubsForm-body']/parent::div[1]/following-sibling::div[5]/div/ul/li")
	public WebElement taxNRCDropDownValue;
	
	@FindBy(id="saveSubsBtn-btnIconEl")
	public WebElement servcPlanSave;
	
	@FindBy(id="invoiceButton-btnIconEl")
	public WebElement invoice;
	
	@FindBy(xpath="//*[@class='x-menu-item-text' and text()='Run Invoice']")
	public WebElement runInvoice;
	
	@FindBy(xpath="//*[@id='invoiceDate-inputCell']/following-sibling::td[1]/div")
	public WebElement InvoiceDate;
	
	@FindBy(xpath="//*[@class='x-datepicker-header']/following-sibling::div[1]/a/span/span/span[2]")
	public WebElement InvoideDatePicker;
	
	@FindBy(xpath="//*[@id='runInvoiceForm-innerCt']/table[2]/tbody/tr/td[2]/input")
	public WebElement trailInvoice;
	
	@FindBy(xpath="//span[@class='x-btn-inner x-btn-inner-center' and text()='Run Invoice']/following-sibling::span")
	public WebElement runTrailInvoice;
	
	@FindBy(xpath="//a[contains(@href,'showsessioninvoice.action')]/font[contains(text(),'View Invoice as HTML')]")
	public WebElement viewInvoice;
	
	@FindBy(xpath="//*[@class='page']")
	public WebElement viewInvoiceReport;
	
	
	public CreateOrganisation(){
		PageFactory.initElements(driver, this);
	}

	
	
	public Boolean selectDomain(String dmn)
	{
		boolean name = false;
		try {
			srchDomain.sendKeys(dmn);
			Thread.sleep(3000);
			srchDomainName.click();
			name = true;
		} catch (Exception e) {
			e.getMessage();
			e.printStackTrace();
		}
		return name;
		
	}


	public void selectContract()
	{
		try {
			cntrctList.click();
			Thread.sleep(3000);
			cntrctListBillTo.click();
			
		} catch (Exception e) {
			e.getMessage();
			e.printStackTrace();
		}
		
	}

	public Boolean addBillFrequency(WebElement ele, String vlue)
	{
		boolean frqncy = false;
		try {
			ele.sendKeys(vlue);
			Thread.sleep(1000);
			frqncy = true;
		} catch (Exception e) {
			e.getMessage();
			e.printStackTrace();
		}
		return frqncy;
		
	}



}
