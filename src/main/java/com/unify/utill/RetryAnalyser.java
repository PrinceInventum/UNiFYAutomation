package com.unify.utill;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyser implements IRetryAnalyzer {
	
	
	int counter = 0;
	int retryLimit = 1;
	
	public boolean retry(ITestResult iTestResult) {
	        if (!iTestResult.isSuccess()) {                      
	            if (counter < retryLimit) {                           
	            	counter++;                                     
	                iTestResult.setStatus(ITestResult.FAILURE);  
	                return true;                                 
	            } else {
	                iTestResult.setStatus(ITestResult.FAILURE);  
	            }
	        } else {
	            iTestResult.setStatus(ITestResult.SUCCESS);     
	        }
	        return false;
	    }
	

}
