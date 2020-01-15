package com.unify.Pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.unify.base.TestBase;

public class ServicePlanPage extends TestBase{
	Logger logger = Logger.getLogger(ServicePlanPage.class);
	@FindBy(xpath="//a[@class='NavLink' and text()= 'Products']")
	public WebElement prducts;

	@FindBy(xpath="//a[@class='PopupLinks' and text()= 'Service Plans']")
	public WebElement srvcPlan;

	@FindBy(id="spmTabs_header_hd-textEl")
	public WebElement pageHeader;

	@FindBy(xpath="//a[@id='addRatePlanBtn']")
	public WebElement addSrvcPlan;

	@FindBy(xpath="//td[@id='ratePlanTypeId-inputCell']/following-sibling::td[1]/div[1]")
	public WebElement planType;
	
	@FindBy(xpath="//ul[@class='x-list-plain']/li[1]")
	public WebElement postPaid;
	
	@FindBy(id="servicePlanFocusID-inputEl")
	public WebElement plnID;
	
	@FindBy(id="textfield-1117-inputEl")
	public WebElement discription;
	
	@FindBy(id="billCycleValidityId-inputEl")
	public WebElement billCycle;
	
	@FindBy(xpath="//td[@id='validitychangeUnitId-inputCell']/following-sibling::td[1]/div[1]")
	public WebElement billPeriod;
	
	@FindBy(xpath="//ul[@class='x-list-plain']/li[5]")
	public WebElement slctBillPeriod;
	
	@FindBy(id="saveServicePlanBtn-btnIconEl")
	public WebElement save;
	
	@FindBy(id="triggerfield-1031-inputEl")
	public WebElement srchPlanID;
	
	@FindBy(xpath="//*[@class='x-grid-cell-inner ' and text()='ServicePlan_001']")
	public WebElement verifyAddedSrchPlanID;
	
	@FindBy(xpath="//*[@class='x-grid-cell-inner ' and text()='20Mbpsdemo']")
	public WebElement verifyAddedSrchPlanID2;
	
	@FindBy(xpath="//*[@class='x-grid-row-checker']")
	public WebElement slctSP;
	
	@FindBy(id="deleteRatePlanBtn-btnInnerEl")
	public WebElement deleteSP;
	
	@FindBy(xpath="//*[@id='messagebox-1001-toolbar-targetEl']/a[2]")
	public WebElement deleteYes;
	
	@FindBy(id="gridview-1029-record-ext-record-1273")
	public WebElement srvcPlan1;
	
	
	
	
	public ServicePlanPage(){
		PageFactory.initElements(driver, this);
	}

	
	
	
	public boolean vrfySerchPlanId(String text){
		 boolean search= false;
		 try {
			 Thread.sleep(2000);
			  srchPlanID.click();
			  srchPlanID.sendKeys(text);
			 
			  srchPlanID.sendKeys(Keys.ENTER);
			  search = true;
			
		} catch (Exception e) {
			e.printStackTrace();
			e.getMessage();
		}
		 
		return search;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
