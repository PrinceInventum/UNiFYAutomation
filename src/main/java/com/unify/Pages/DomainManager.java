package com.unify.Pages;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.unify.base.TestBase;

public class DomainManager extends TestBase{

	Logger logger = Logger.getLogger(DomainManager.class);

	@FindBy(xpath="//a[@class='NavLink' and text()= 'Domains']")
	public WebElement domainLink;

	@FindBy(xpath="//a[@class='PopupLinks' and text()= 'Domains Manager']")
	public WebElement domainManager;

	@FindBy(id="topSubnetPanel_header_hd-textEl")
	public WebElement firstlink;

	@FindBy(xpath="//*[contains(@class,'x-tree-node-text')]")
	public List<WebElement> allelmnts;

	@FindBy(xpath="//*[@id='ext-gen1437']/div[1]/span[1]")
	public WebElement parentDomain;

	@FindBy(id="textfield-1018-labelEl")
	public WebElement unqueId;

	@FindBy(name="domain.domid")
	public WebElement unqueIdName;

	@FindBy(id="domainTabsId-body")
	public WebElement domnTab;

	@FindBy(id="textfield-1019-labelEl")
	public WebElement domainName;

	@FindBy(name="domain.name")
	public WebElement domainNameAtribute;

	@FindBy(id="tab-1056-btnInnerEl")
	public WebElement contactDetails;

	@FindBy(id="domainFormContactGrid")
	public List<WebElement> contactDetailsTablist;

	@FindBy(xpath="//*[@data-qtip='Add Row']")
	public WebElement addRow;

	@FindBy(id="ext-gen1523")
	public WebElement contactType;

	@FindBy(xpath="//ul[@class='x-list-plain']")
	public WebElement contactTypeList;

	@FindBy(xpath="//ul[@class='x-list-plain']/li[1]")
	public WebElement contactTypeAdmns;

	@FindBy(xpath="//*[@id='gridview-1036-body']/tr[1]/td[2]")
	public WebElement frstNameField;

	@FindBy(name="firstName")
	public WebElement frstName;

	@FindBy(xpath="//*[@id='gridview-1036-body']/tr[1]/td[3]")
	public WebElement lastNameField;

	@FindBy(name="lastName")
	public WebElement lstName;

	@FindBy(xpath="//*[@id='gridview-1036-body']/tr[1]/td[4]")
	public WebElement cntry;

	@FindBy(id="ext-gen1544")
	public WebElement cntryDropDown;

	@FindBy(id="contactCountry-inputEl")
	public WebElement cntryNameField;

	@FindBy(xpath="//li[@class='x-boundlist-item' and text()='India']")
	public WebElement cntryName;

	@FindBy(xpath="//*[@id='gridview-1036-body']/tr[1]/td[5]")
	public WebElement city;
	
	@FindBy(id="contactCity-inputEl")
	public WebElement cntryCityField;
	
	@FindBy(xpath="//li[@class='x-boundlist-item' and text()='Noida']")
	public WebElement cityName;
	
	//*****Nextra_Xpath*****
	
	@FindBy(xpath="//span[contains(@class,'x-tree-node-text  ') and text()='Nextra {Nextra} ']")
	public WebElement nextraDomain;
	
	@FindBy(id="domainFormParentCmbId-labelEl")
	public WebElement parentDmain;
	
	@FindBy(name="domain.parentDomainName")
	public WebElement parentDomainNameAtribute;
	
	@FindBy(id="domainTabsId-body")
	public WebElement NextraDetails;
	
	@FindBy(name="domain.domid")
	public WebElement coptText;
	
	@FindBy(xpath ="//*[@class='x-tree-node-text  ' and text()='SSG Admin {admin} ']")
	public WebElement nxc;
	
	
	public DomainManager(){
		PageFactory.initElements(driver, this);
	}


	public boolean countryField()
	{
		boolean contry = false;
			try {
				cntryNameField.sendKeys("India");
				cntryName.click();
				contry=true;
				
			} catch (Exception e) {
				e.printStackTrace();
				e.getMessage();
			}
		
		return contry;
	}
	
	
	public boolean cityField()
	{
		boolean city = false;
			try {
				cntryCityField.sendKeys("Noida");
				cityName.click();
				city=true;
			} catch (Exception e) {
				e.printStackTrace();
				e.getMessage();
			}
		
		return city;
	}



}