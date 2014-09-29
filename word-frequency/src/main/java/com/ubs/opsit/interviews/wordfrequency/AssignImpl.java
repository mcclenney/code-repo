package com.ubs.opsit.interviews.wordfrequency;

import java.util.HashMap;
import java.util.Map;

public class AssignImpl implements WordFrequency {

	private Map<String, Integer> hm = new HashMap<String, Integer>();
	
	@Override
	public synchronized Map<String, Integer> countOccurrencesOfWordsWithin(String evalString) {
		
		// Throw exceptions for empty or null string
		if(evalString == null || evalString.isEmpty()) {
			throw new IllegalArgumentException("The string cannot be null or empty.");
		}
		
		// Split the string into tokens based on the spaces in the string, then loop through tokens.
		// If the token exists in the HashMap as a key, increment the key's value by 1,
		// else add the token to the HashMap with a value of 1.
		String[] result = evalString.split("\\s");
		for (int x=0; x<result.length; x++) {
			if (hm.containsKey(result[x])) {
				hm.put(result[x], hm.get(result[x])+1);
			}
			else {
				hm.put(result[x], 1);
			}
		}
		
		return hm;
	}

}