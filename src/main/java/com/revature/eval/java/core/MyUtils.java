package com.revature.eval.java.core;

public class MyUtils {

	/*==========Constants==========*/
	
	/*==========Simple Methods==========*/
	
	/*==========Complex Methods==========*/
	
	/**
	 * Validate NANP number
	 * Check an all-digit string against the NANP format
	 * Return empty string for invalid NANP
	 */
	public boolean isValidNANP(String string) {
		
		// Check Length
		if (string.length() > 11 || string.length() < 10) {
			return false;
		}
		
		// Eliminate the country code
		if (string.length() == 11 && !string.startsWith("1")) {
			return false;
		}
		else {
			string = string.substring(1);
		}
		
		// Check N (2-9) position digits
		if (string.charAt(0) == '0' || string.charAt(0) == '1') {
			return false;
		}
		if (string.charAt(3) == '0' || string.charAt(3) == '1') {
			return false;
		}
		
		return true;
		
	}
	
}
