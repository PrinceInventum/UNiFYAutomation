package com.unify.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.unify.base.TestBase;

public class BillingPage extends TestBase {
	
	@FindBy(xpath="//a[@class='NavLink' and text()='Billing']")
	public WebElement BillingLink;
	
	@FindBy(xpath="//a[@class='PopupLinks' and text()='Charges']")
	public WebElement BillingCharge;
	
	@FindBy(xpath="//span[@class='x-menu-item-text' and text()='Recurring Charges']")
	public WebElement RcChrges;
	
	@FindBy(id="rcAddBtnId-btnIconEl")
	public WebElement addRcBtn;
	
	@FindBy(name="billRecCharges.brcid")
	public WebElement rcId;
	
	@FindBy(name="billRecCharges.brcdesc")
	public WebElement rcName;
	
	@FindBy(id="multiDomainID-inputEl")
	public WebElement multiDomain;
	
	
	public BillingPage(){
		PageFactory.initElements(driver, this);
	}
	
	
	
	public boolean addValue(WebElement link, String text)
	{
		boolean value=false;

		link.click();
		link.sendKeys(text);

		value = true;


		return value;

	}	
	
	
	



}