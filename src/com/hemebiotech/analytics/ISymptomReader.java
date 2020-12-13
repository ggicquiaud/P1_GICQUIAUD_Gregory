package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

/**
 * Anything that will read symptom data from a source
 * The important part is, the return value from the operation, which is a list of strings,
 * that may contain many duplications
 * 
 * The implementation does not need to order the list
 * 
 */
public interface ISymptomReader {
	/**
	 * if not avalible, return an empty list	
	 * @param filepath
	 * @return
	 * @throws streamException
	 */
	List<String> GetSymptoms (String filepath) throws streamException;
	/**
	 * transforms the raw listing into map with symptoms and number of occurences
	 * @param listSymptom
	 * @return
	 */
	Map<String, Integer> countOccurancesSymptome (List<String> listSymptom);
	/**
	 * write the final list into a file
	 * @param laMap
	 * @throws FileWriterException
	 */
	void ecrireSymptomeOccurancesDansFichier(Map<String, Integer> laMap) throws FileWriterException;
}
