package com.revature.eval.java.core;

public class MyUtils {

	/*==========Constants==========*/
	
	// Alphabet characters
	public final String UPPER_CASE_ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	public final String LOWER_CASE_ALPHABET = "abcdefghijklmnopqrstuvwxyz";
	
	/*==========Simple Methods==========*/
	
	/**
	 * Check if a character is a vowel (in lowercase)
	 */
	
	public boolean isVowel(char c) {
		return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
	}
	
	/*==========Complex Methods==========*/
	
	/**
	 * Validate NANP number
	 * Check an all-digit string against the NANP format
	 * Return false for invalid NANP
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
	
	/**
	 * Translate a single English word into a Pig Latin word
	 * Output will always be in lowercase
	 */
	public String englishWordToPigLatin(String string) {

		// Use StringBuilder to perform operation
		StringBuilder pigLatinString = new StringBuilder(string);
		StringBuilder consonantCluster = new StringBuilder("");
		
		// Split the word into a char array
		char[] allInputLetters = string.toLowerCase().toCharArray();
		
		for (int i = 0; i < allInputLetters.length; ++i) {
			// Add consonants into the cluster
			if (!isVowel(allInputLetters[i])) {
				consonantCluster.append(allInputLetters[i]);
			}
			else if (allInputLetters[i] == 'u') {
				// A special case for the "qu" cluster
				if (consonantCluster.length() > 0 && consonantCluster.charAt(consonantCluster.length() - 1) == 'q') {
					consonantCluster.append(allInputLetters[i]);
				}
				else {
					break;
				}
			}
			// Stop adding consonants when the first vowel occurs
			else if (isVowel(allInputLetters[i])) {
				break;
			}
		}
		
		// Shift consonant cluster if any
		if (consonantCluster.length() > 0) {
			pigLatinString.append(consonantCluster);
			pigLatinString.delete(0, consonantCluster.length());
		}
		
		// Append "ay"
		pigLatinString.append("ay");
		
		return new String(pigLatinString);
		
	}
	
	/**
	 * Check if an integer (long) is a prime number
	 */
	public boolean isPrime(long number) {
		
		// Check for invalid input
		if (number < 2) {
			throw new IllegalArgumentException();
		}
		
		for (long i = 2; i < number; ++i) {
			if (number % i == 0) {
				// Not a prime
				return false;
			}
		}
		// Must be a prime if for loop exits
		return true;
		
	}
	
	/**
	 * Transform a single char into a Caesar cipher char using a key
	 * Non-alphabet chars are returned as themselves
	 */
	public char toCaesarChar(char c, int key) {
		
		// Transform an UPPERCASE letter
		if (this.UPPER_CASE_ALPHABET.indexOf(c) != -1) {
			// Shift the char by computing a new index
			int newIndex = (this.UPPER_CASE_ALPHABET.indexOf(c) + key) % 26;
			return this.UPPER_CASE_ALPHABET.charAt(newIndex);
		}
		// Do the same for a lowercase letter
		else if (this.LOWER_CASE_ALPHABET.indexOf(c) != -1) {
			int newIndex = (this.LOWER_CASE_ALPHABET.indexOf(c) + key) % 26;
			return this.LOWER_CASE_ALPHABET.charAt(newIndex);
		}
		// Return non-alphabet char as is
		else {
			return c;
		}
		
	}
	
	/**
	 * Transform a single char (in lowercase) into its Atbash counterpart
	 * This method works for both encoding and decoding
	 * Non-alphabet chars are returned as themselves
	 */
	public char toAtbash(char c) {
		
		// Alphabet characters
		if (this.LOWER_CASE_ALPHABET.indexOf(c) != -1) {
			int newIndex = 25 - this.LOWER_CASE_ALPHABET.indexOf(c);
			return this.LOWER_CASE_ALPHABET.charAt(newIndex);
		}
		// Non-alphabet characters
		else {
			return c;
		}
		
	}
	
}
