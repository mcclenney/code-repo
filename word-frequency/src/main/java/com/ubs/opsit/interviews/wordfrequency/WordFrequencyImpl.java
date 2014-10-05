package com.ubs.opsit.interviews.wordfrequency;

import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class WordFrequencyImpl implements WordFrequency {

	private ConcurrentHashMap<String, Integer> wordCounts = new ConcurrentHashMap<String, Integer>();
	
	@Override
	public Map<String, Integer> countOccurrencesOfWordsWithin(String stringToEvaluate) {
		
		if(stringToEvaluate == null || stringToEvaluate.isEmpty()) {
			throw new IllegalArgumentException("The string cannot be null or empty.");
		}
		
		String[] words = stringToEvaluate.split("\\s");
		Integer currentWordCount, newWordCount;
		
		for (int x=0; x<words.length; x++) {
			currentWordCount = wordCounts.putIfAbsent(words[x], 1);
			if (currentWordCount != null) {
				do {
		            currentWordCount = wordCounts.get(words[x]);
		            newWordCount = currentWordCount + 1;
		        } while (!wordCounts.replace(words[x], currentWordCount, newWordCount));
			}
		}
		
		return Collections.unmodifiableMap(wordCounts);
	}

}