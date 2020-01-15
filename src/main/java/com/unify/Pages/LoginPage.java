package com.unify.Pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.unify.base.TestBase;


public class LoginPage extends TestBase {
	
	Logger logger = Logger.getLogger(LoginPage.class);
	
	@FindBy(id="username")
	private  WebElement user;

	@FindBy(id="password")
	private  WebElement pswd;

	@FindBy(id="domain")
	private  WebElement domainField;

	@FindBy(xpath="//button[@type='submit']")
	public  WebElement submt;
	
	@FindBy(xpath="//*[@id='ui-dialog-title-dialogdiv']/div[1]")
	public  WebElement trmsCondtionAlert;

	@FindBy(xpath="//*[@class='ui-dialog-titlebar-close ui-corner-all']")
	public  WebElement trmsCondtionAlertCrossBtn;
	
	@FindBy(id="tacData")
	public  WebElement trmsCondtionText;
	
	@FindBy(xpath="//*[@id='sendmail']")
	public  WebElement trmsCondtionAgrmnt;
	
	@FindBy(xpath="//*[@class='ui-button-text' and text()='Accept']")
	public  WebElement accept;
	
	@FindBy(xpath="//*[@class='ui-button-text' and text()='Deny']")
	public  WebElement deny;
	
	@FindBy(id="ui-dialog-title-unify-alert-dialog")
	public  WebElement denyAlert;
	
	@FindBy(xpath="//*[@class='unify-dialog-message']")
	public  WebElement denyAlertMsg;
	
	@FindBy(xpath="//*[@class='ui-button-text' and text()='OK']")
	public  WebElement denyAlertOk;
	
	@FindBy(xpath="//*[@class='message']")
	public  WebElement invalidLoginMsg;
	
	@FindBy(xpath="//*[@class='login-section']/h3[1]")
	public  WebElement loginheder;
	
	@FindBy(xpath="//*[@id='login']/ul[1]/li[1]/label[1]")
	public  WebElement un;
	
	@FindBy(xpath="//*[@id='login']/ul[1]/li[2]/label[1]")
	public  WebElement pw;
	
	@FindBy(xpath="//*[@id='login']/ul[1]/li[3]/label[1]")
	public  WebElement dman;
	
	@FindBy(xpath="//*[@class='remember']/span[1]")
	public  WebElement stayLogn;
	
	@FindBy(id="rememberme")
	public  WebElement remembr;
	
	
	@FindBy(xpath="//*[@id='toppanel']/a[1]")
	public  WebElement logout;
	
	@FindBy(id="ui-dialog-title-unify-logout-dialog")
	public  WebElement logoutHeader;
	
	@FindBy(xpath="//*[@class='ui-icon ui-icon-closethick' and text()= 'close']")
	public  WebElement logoutCrossButton;
	
	@FindBy(xpath="//div[@class='unify-dialog-message']")
	public  WebElement logoutText;
	
	@FindBy(xpath="//*[@class='ui-button-text' and text()='Cancel']")
	public  WebElement logoutCancel;
	
	@FindBy(xpath="//*[@class='ui-button-text' and text()='OK']")
	public  WebElement logoutOk;
	
	
	
	
	
	
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}
	
	public DashBoardPage Login(String un, String pwd, String dmn ) {

		try {
			Thread.sleep(500);
			user.sendKeys(un);
			pswd.sendKeys(pwd);
			domainField.sendKeys(dmn);
			submt.click();
			
		}
		catch (Exception e)
		{
			e.getMessage();
			e.printStackTrace();
		}

		return new DashBoardPage();


	}
	
	public boolean isAgreementSelected() {
		boolean open = false;
		if (trmsCondtionAgrmnt != null && trmsCondtionAgrmnt.isSelected()) {
			System.out.println("\n"+"Agreement checkBox is selected");
			trmsCondtionAgrmnt.click();
			open = true;
		}
		return open;
	}
	
	public boolean isRememberMeSelected() {
		boolean open = false;
		if (remembr != null && remembr.isSelected()) {
			System.out.println("\n"+"Remember Me checkBox is selected");
			remembr.click();
			open = true;
		}
		return open;
	}

}
