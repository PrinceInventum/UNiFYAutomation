package com.unify.Pages;


import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.unify.base.TestBase;

public class DashBoardPage extends TestBase {

	Logger logger = Logger.getLogger(DashBoardPage.class);

	@FindBy(xpath="//a[@id='logoid']/img[1]")
	public WebElement logo;

	@FindBy(id="mainNav")
	public WebElement allPages;

	@FindBy(xpath="//*[@id='toppanel']")
	public WebElement wlcmText;

	@FindBy(xpath="//a[@class='NavLink' and text()= 'Domains']")
	public WebElement domainLink;

	public DashBoardPage(){
		PageFactory.initElements(driver, this);

	}










}
