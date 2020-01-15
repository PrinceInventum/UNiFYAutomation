package com.unify.testPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.unify.utill.Excel_Reader;

public class DataDrivenTest {

	public static void main(String[] args) {
		
		System.out.println("****EXECUTING UNIFY SCRIPT ON CHROME BROWSER****");
		System.setProperty("webdriver.chrome.driver","/home/princeambast/Downloads/Driver/Chrome/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://172.16.0.70:9080/unifyadmin/login.do");
		
		Excel_Reader reder = new Excel_Reader("/home/princeambast/Desktop/Test.xlsx");			
		
		
	    String user_name =	reder.getCellData("organisation", "Domain_Name", 14);
		
	    System.out.println(user_name);
			
		driver.findElement(By.id("username")).sendKeys(reder.getCellData("ABC", "CDF", 2));
		driver.findElement(By.id("password")).sendKeys(reder.getCellData("ABC", "CDF", 2));
		driver.findElement(By.id("domain")).sendKeys(reder.getCellData("ABC", "CDF", 2));
		
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		driver.quit();
	}

}