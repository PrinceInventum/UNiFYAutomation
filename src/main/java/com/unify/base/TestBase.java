package com.unify.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;


public class TestBase {

	public static WebDriver driver;
	public static Properties prop;

	public TestBase(){

		try {
			prop = new Properties();
			FileInputStream fip = new FileInputStream("/home/princeambast/workspace/UnifySMP/src/main/java/com/unify/config/config.properties");
			prop.load(fip);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
			e.getMessage();
		}
		catch (IOException e) {
			e.printStackTrace();
			e.getMessage();
		}

	}
	
	
	@BeforeMethod
	@Parameters(value="browser")
	public static void setupBrowser(String browser){
	
		try {
			if(browser.equalsIgnoreCase("firefox")){
				System.out.println("\n"+"****EXECUTING UNIFY SCRIPT ON FIREFOX BROWSER****");
				System.setProperty("webdriver.gecko.driver", "/home/princeambast/Downloads/DRIVER/geckodriver");
				System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"false");
				driver = new FirefoxDriver();
				
			}
			else if(browser.equalsIgnoreCase("chrome")){
				System.out.println("\n"+"****EXECUTING UNIFY SCRIPT ON CHROME BROWSER****");
				
				ChromeOptions options = new ChromeOptions(); 
				options.addArguments("disable-infobars"); 
				
				System.setProperty("webdriver.chrome.driver","/home/princeambast/Downloads/DRIVER/chromedriver");
				driver = new ChromeDriver(options);
			}

			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.get(prop.getProperty("url"));
			System.out.println("\n"+"Open UNIFY login Page");
			long start = System.currentTimeMillis();
			driver.get(prop.getProperty("url"));
			long finish = System.currentTimeMillis();
			long totalTime = finish - start; 
			System.out.println("\n"+"Total Time to load Unify website is- "+totalTime +" "+"milliseconds");
			
			
			
		}
		catch (Exception e) {
			e.getMessage();
			e.printStackTrace();
		}
		
	
	}
	
	
	
	
	
}
