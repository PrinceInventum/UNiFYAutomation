package com.unify.CommonsClass;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import com.unify.base.TestBase;


public class CommonClass extends TestBase{

	Logger logger = Logger.getLogger(CommonClass.class);

	public String dynamicSendkeys(String inputData, WebElement webElement){

		String currenttime = new SimpleDateFormat("EHHmmss").format(Calendar.getInstance().getTime());
		String originalValue = inputData;
		String combinedValues = originalValue+currenttime;
		sendKeys(webElement, combinedValues);

		webElement.sendKeys(combinedValues);

		return combinedValues;
	}

	private void sendKeys(WebElement webElement, String combinedValues) {

	}

	public static boolean getListofLink(WebElement primary, List<WebElement> allLinks ){
		boolean AvailableLink = false;

		WebElement linkPresent = primary;
		if (linkPresent!=null) {
			List<WebElement> allsuggestion = (List<WebElement>) allLinks;

			System.out.println("********Available link on page*******");

			for (WebElement suggestion : allsuggestion) {
				System.out.println(suggestion.getText());
			}
			System.out.println("******Above are the availbale links******");

			AvailableLink = true;
		}
		else
		{
			System.out.println("List is not present on WebPage");
		}
		return AvailableLink;

	}



	public boolean mouseoverEements(WebElement primary, WebElement secoundary ){
		boolean elementMouseOver = false;
		try {
			Thread.sleep(1000);
			Actions action = new Actions(driver);
			action.moveToElement(primary).build().perform();
			secoundary.click();
			elementMouseOver=true;

		} 
		catch (InterruptedException e) {
			e.printStackTrace();
			e.getMessage();
		}

		return elementMouseOver;

	}


	public String GetAvailableText(WebElement getText)  {
		String text = null;
		WebElement availableText = getText;
		if (availableText != null && availableText.isDisplayed()) {
			try {
				Thread.sleep(1000);
				text = availableText.getText();
				System.out.println("Available Text:  " + text);

			} catch (InterruptedException e) {
				e.printStackTrace();
				e.getMessage();
			}
		}
		return text;
	}


	public boolean isPagedisplaying(WebElement links) {
		boolean open = false;
		WebElement login = links;
		if (login != null && login.isDisplayed()) {
			String ele =	login.getText();
			System.out.println("\n"+ele);
			open = true;
		}
		return open;
	}


	public boolean Openlinks(WebElement link){
		boolean	clickOnLink = false;

		try {

			Thread.sleep(500);
			link.click();
			clickOnLink = true;

		} catch (Exception e) {
			e.getMessage();
			e.printStackTrace();

		}
		return clickOnLink;

	}


	public boolean addValue(WebElement link, String text)
	{
		boolean value=false;

		link.click();
		link.sendKeys(text);

		value = true;


		return value;

	}


	public boolean clickOnTwoWebElements(WebElement linkA, WebElement linkB)

	{
		boolean value=false;

		try {
			Thread.sleep(500);
			linkA.click();
			Thread.sleep(2000);
			linkB.click();
			value = true;
		} catch (Exception e) {
			e.printStackTrace();
			e.getMessage();
		}
		return value;

	}

	public boolean CalculatePageLoadTime(WebElement elements , String text, WebElement ele1, String sopText){
		boolean exactTime= false;

		elements.sendKeys(text);

		elements.sendKeys(Keys.ENTER);
		long start = System.currentTimeMillis();
		System.out.println("Page load starting");
		ele1.isDisplayed();
		long finish = System.currentTimeMillis();
		long totalTime = finish - start; 

		exactTime = true;

		System.out.println(sopText+" -" +totalTime+" "+"milliseconds");

		return exactTime;
	}



	public boolean CalculatePageLoadTime(WebElement ele1){
		boolean exactTime= false;

		long start = System.currentTimeMillis();
		System.out.println("Page load starting");
		ele1.isDisplayed();
		long finish = System.currentTimeMillis();
		long totalTime = finish - start; 

		exactTime = true;

		System.out.println("Total Time taken to show service plan list - "+totalTime+" "+"milliseconds");

		return exactTime;
	}


	public boolean mouseoverThreeEements(WebElement primary, WebElement secoundary, WebElement last ){
		boolean elementMouseOver = false;
		try {
			Thread.sleep(1000);
			Actions action = new Actions(driver);
			action.moveToElement(primary).build().perform();
			Thread.sleep(1000);
			Actions action2 = new Actions(driver);
			action2.moveToElement(secoundary).build().perform();
			last.click();
			elementMouseOver=true;
		} 
		catch (InterruptedException e) {
			e.printStackTrace();
		}
		return elementMouseOver;

	}


	public boolean sendKeysData(WebElement elemnt, String value, WebElement secondElements){
		boolean sndData=false;
		try {
			elemnt.sendKeys(value);
			Thread.sleep(3000);
			secondElements.click();
			sndData=true;
		} catch (Exception e) {
			e.printStackTrace();
			e.getMessage();
		}
		return sndData;
	}


	public String getAtributeValue(WebElement ele){
		String availableText=ele.getAttribute("value");
		System.out.println(availableText);
		return availableText;

	}




	public boolean rightClickOnElements(WebElement elemnt){
		boolean rgtClick=false;
		try {
			Thread.sleep(2000);
			Actions actions = new Actions(driver);
			actions.contextClick(elemnt).build().perform();
			rgtClick=true;
			
		} catch (Exception e) {
			e.printStackTrace();
			e.getMessage();
		}
		return rgtClick;
	}





}