package com.unify.Pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.unify.base.TestBase;

public class ServiceCardPage extends TestBase {
	Logger logger = Logger.getLogger(ServiceCardPage.class);
	
	@FindBy(xpath="//a[@class='NavLink' and text()= 'Products']")
	public WebElement prducts;
	
	@FindBy(xpath="//a[@class='PopupLinks' and text()='Service Card']")
	private  WebElement srvcCard;
	
	@FindBy(id="couponViewID_header_hd-textEl")
	public WebElement pageHeader;
	
	
	
	
	public ServiceCardPage(){
		PageFactory.initElements(driver, this);

	}
	
	
	
	

}
