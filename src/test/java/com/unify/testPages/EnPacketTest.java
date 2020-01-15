package com.unify.testPages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class EnPacketTest {

	public static void main(String[] args) throws InterruptedException, AWTException {
		

		System.setProperty("webdriver.chrome.driver","/home/princeambast/Downloads/Driver/Chrome/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("");
		Thread.sleep(3000);
		
		
		String userName = ""+(int)(Math.random()*Integer.MAX_VALUE);
		String emailID = "User"+userName+"@yopmail.com";
		
		System.out.println(emailID);
		
		
		driver.findElement(By.name("login_username")).sendKeys("");
		driver.findElement(By.name("login_password")).sendKeys("");

		
		
		
		
		driver.findElement(By.id("submitme")).click();
		
		Thread.sleep(3000);
		
		Robot robot = new Robot();                          
		robot.keyPress(KeyEvent.VK_CONTROL); 
		robot.keyPress(KeyEvent.VK_T); 
		robot.keyRelease(KeyEvent.VK_CONTROL); 
		robot.keyRelease(KeyEvent.VK_T);

		//Switch focus to new tab
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		

		
		String copy = Keys.chord(Keys.CONTROL,Keys.chord("v"));
		driver.get(copy);
		
		driver.findElement(By.xpath("//*[@type='submit']")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//*[@class='btn btn-primary dropdown-toggle']")).click();

		driver.findElement(By.id("addAccessPoint")).click();
		Thread.sleep(2000);
		System.out.println("PopUp Header is : "+ driver.findElement(By.xpath("//*[@class='modal-title']")).getText());

		System.out.println("PopUp text is : "+ driver.findElement(By.id("first")).getText());

		driver.findElement(By.xpath("//*[@class='btn btn-primary']")).click();

		driver.findElement(By.xpath("//*[@class='btn btn-primary']")).click();

		driver.findElement(By.xpath("//div[@name='orgName']/div[1]/span[1]")).click();

		driver.findElement(By.xpath("//*[@ng-change='changeOrgList()']/input[1]")).sendKeys("Inventum");

		driver.findElement(By.xpath("//div[@class='ng-binding ng-scope' and text()='Inventum']")).click();
		
		driver.findElement(By.xpath("//div[@name='networkName']/div[1]/span[1]")).click();
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//*[@id='ui-select-choices-row-2-6']/span[1]/div[1]")).click();
		
		driver.findElement(By.xpath("//div[@name='networkName']/div[1]/span[1]")).click();

		driver.findElement(By.xpath("//div[@class='ng-binding ng-scope']")).click();

		driver.findElement(By.xpath("//a[@class='btn btn-primary']")).click();

		driver.findElement(By.id("deviceType")).click();

		driver.findElement(By.xpath("//*[@id='deviceType']/option[14]")).click();

		driver.findElement(By.name("deviceSerial")).sendKeys("50:C7:BF:F9:70:7C");

		driver.findElement(By.xpath("//a[@class='btn btn-primary']")).click();

		Thread.sleep(3000);

		String PageText = driver.findElement(By.xpath("//*[@name='lastForm']/h2[1]")).getText();

		if (PageText!="Please power-on your Access Point and connect the WAN port to a DHCP enabled router. All configuration suitable for the device will be downloaded automatically to it.") {

			System.out.println("Device mac address not added before..now going to add");
			WebElement add = driver.findElement(By.xpath("//*[@ng-click='completeWizard()']"));
			add.click();
			
			if (add!=null) {
				driver.findElement(By.xpath("//*[@title='Configure']/b[1]")).click();
				driver.findElement(By.xpath("//*[@title='Configure']/b[1]")).click();

			}
			
			
		} 
		else {
			System.out.println("mac address not added before");
		}
	}


	
	
	
}