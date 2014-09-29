package com.ubs.opsit.interviews.wordfrequency;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import com.ubs.opsit.interviews.wordfrequency.AssignImpl;

public class WordFrequencyTest {
	
	private AssignImpl myImpl = new AssignImpl();
	private Map<String, Integer> testMap = new HashMap<String, Integer>();
	
	@Test
    public void testExample() {
		String testString1 = "the man in the moon";
		String testString2 = "the man on the moon";
		
    	testMap.put("the", 2);
    	testMap.put("man", 1);
    	testMap.put("in", 1);
    	testMap.put("moon", 1);
    	
    	Assert.assertEquals(testMap, myImpl.countOccurrencesOfWordsWithin(testString1));
    	
    	testMap.put("the", 4);
    	testMap.put("man", 2);
    	testMap.put("in", 1);
    	testMap.put("on", 1);
    	testMap.put("moon", 2);
    	
    	Assert.assertEquals(testMap, myImpl.countOccurrencesOfWordsWithin(testString2));
    }
	
	@Test(expected=IllegalArgumentException.class)
	public void testNullString() {
		String nullString = null;
	    myImpl.countOccurrencesOfWordsWithin(nullString);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testEmptyString() {
		String emptyString = "";
	    myImpl.countOccurrencesOfWordsWithin(emptyString);
	}

}