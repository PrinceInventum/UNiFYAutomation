package com.unify.utill;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.unify.base.TestBase;

public class ScreenShots extends TestBase{
	
	
	public static void failed(String testMethodName)
	{
	File srcFile =	((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	
	try {
		FileUtils.copyFile(srcFile, new File("/home/princeambast/workspace/UnifySMP/Screenshots/"+testMethodName+"_"+".jpg"));
	
	} catch (IOException e) {
		e.printStackTrace();
		e.getMessage();
	}
	}
	
	

}
