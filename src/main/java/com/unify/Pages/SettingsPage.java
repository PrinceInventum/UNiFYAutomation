package com.unify.Pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.unify.base.TestBase;

public class SettingsPage extends TestBase{
	
	Logger logger = Logger.getLogger(SettingsPage.class);
	
	@FindBy(xpath="//a[@class='NavLink' and text()='Settings']")
	public WebElement setngs;
	
	@FindBy(xpath="//*[@title='Master Settings']")
	public WebElement masterStngs;
	
	@FindBy(xpath="//*[@title='Master Data']")
	public WebElement masterDomian;
	
	@FindBy(id="panel-1038_header_hd-textEl")
	public WebElement fnance;
	
	@FindBy(id="menuitem-1041-itemEl")
	public WebElement coa;
	
	@FindBy(id="menuitem-1043-textEl")
	public WebElement coaGrp;
	
	@FindBy(id="menuitem-1043-textEl")
	public WebElement coaF;
	
	@FindBy(id="panel1-1009-body")
	public WebElement pageData;
	
	@FindBy(id="coaListId_header_hd-textEl")
	public WebElement coaHeader;
	
	@FindBy(xpath="//*[contains(@class,'x-btn-icon-el')]")
	public WebElement coaPlusIcon;
	
	@FindBy(xpath="//*[@title='Close form']")
	public WebElement coaCancel;
	
	
	public SettingsPage(){
		PageFactory.initElements(driver, this);

	}

}
