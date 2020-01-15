package com.unify.Pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.unify.base.TestBase;

public class CalculateTime extends TestBase{
	
	Logger logger = Logger.getLogger(CalculateTime.class);
	
	@FindBy(xpath="//a[@class='NavLink' and text()= 'CRM']")
	public WebElement crmlink;
	
	@FindBy(id="topSearchId-inputEl")
	public WebElement srch;
	
	@FindBy(xpath="//div[@class='x-boundlist-list-ct x-unselectable']/div[1]")
	public WebElement srchSuggestion;
	
	
	@FindBy(id="textfield-1090-labelEl")
	public WebElement orgName;
	
	@FindBy(xpath="//a[@class='PopupLinks' and text()= 'Customers']")
	public WebElement customr;
	
	
	@FindBy(xpath="//a[@class='NavLink' and text()= 'Products']")
	public WebElement prducts;

	@FindBy(xpath="//a[@class='PopupLinks' and text()= 'Service Plans']")
	public WebElement srvcPlan;
	
	
	@FindBy(id="ext-gen1339")
	public WebElement list1st;

	@FindBy(xpath="//*[@class='x-list-plain']/li[1]")
	public WebElement list2nd;
	
	@FindBy(id="gen1736")
	public WebElement list;
	
	public CalculateTime(){
		PageFactory.initElements(driver, this);
	}
	
	
	
	public boolean CalculatePageLoadTime(WebElement elements ,WebElement ele2, WebElement ele3){
		boolean exactTime= false;
		
		long start = System.currentTimeMillis();
		elements.click();
		
		ele2.click();
		long finish = System.currentTimeMillis();
		long totalTime = finish - start; 
		
		exactTime = true;
		
		if (exactTime=true) {
			String availableText =ele3.getText();
			System.out.println("Available Text is - "+availableText);
		}
		else 
		{
			System.out.println("data not showing on webpage");
		}
		
		System.out.println("Total Time for page load in milliseconds - "+totalTime);
		
		return exactTime;
	}
	
	
	
	
	

}
