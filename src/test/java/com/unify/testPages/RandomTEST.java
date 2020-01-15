package com.unify.testPages;

import java.util.Random;

public class RandomTEST {

	public static void main(String[] args) {

		Random random = new Random() ;
        int randomNumber = random.nextInt(5) + 2;
		System.out.println(randomNumber);
		
		String userName = ""+(int)(Math.random()*Integer.MAX_VALUE);
		String emailID = "User"+userName+"@yopmail.com";
		
		
		System.out.println(emailID);
		
		
		
		
		
	}

}
