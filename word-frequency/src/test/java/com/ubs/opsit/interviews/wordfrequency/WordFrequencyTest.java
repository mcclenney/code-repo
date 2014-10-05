package com.ubs.opsit.interviews.wordfrequency;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import com.ubs.opsit.interviews.wordfrequency.WordFrequencyImpl;

public class WordFrequencyTest {
	
	private WordFrequency wordFrequencyImpl = new WordFrequencyImpl();
	private Map<String, Integer> wordCounts = new HashMap<String, Integer>();
	
	@Test
    public void shouldReturnCorrectWordCounts() {
		String firstNormalTestString = "the man in the moon";
		String secondNormalTestString = "the man on the moon";
		
    	wordCounts.put("the", 2);
    	wordCounts.put("man", 1);
    	wordCounts.put("in", 1);
    	wordCounts.put("moon", 1);
    	
    	Assert.assertEquals(wordCounts, wordFrequencyImpl.countOccurrencesOfWordsWithin(firstNormalTestString));
    	
    	wordCounts.put("the", 4);
    	wordCounts.put("man", 2);
    	wordCounts.put("in", 1);
    	wordCounts.put("on", 1);
    	wordCounts.put("moon", 2);
    	
    	Assert.assertEquals(wordCounts, wordFrequencyImpl.countOccurrencesOfWordsWithin(secondNormalTestString));
    }
	
	@Test(expected=IllegalArgumentException.class)
	public void shouldThrowExceptionForNullString() {
		String nullString = null;
	    wordFrequencyImpl.countOccurrencesOfWordsWithin(nullString);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void shouldThrowExceptionForEmptyString() {
		String emptyString = "";
	    wordFrequencyImpl.countOccurrencesOfWordsWithin(emptyString);
	}
	
	@Test(expected=UnsupportedOperationException.class)
	public void shouldThrowExceptionForUpdatingReturnedMap() {
		Map<String, Integer> noUpdateAllowedMap = wordFrequencyImpl.countOccurrencesOfWordsWithin("any words here");
		noUpdateAllowedMap.put("anyKey", 1);
	}
}