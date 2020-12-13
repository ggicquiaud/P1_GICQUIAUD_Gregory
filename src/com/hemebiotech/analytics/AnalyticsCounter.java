package com.hemebiotech.analytics;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AnalyticsCounter {
	
	public static void main(String args[]) {
		
		List<String> symptomeDuFichier = new ArrayList<String>();
		
		ReadSymptomDataFromFile resultat = new ReadSymptomDataFromFile();
		
		try {
		symptomeDuFichier = resultat.GetSymptoms("symptoms.txt");
		}catch(streamException e) {
			// File could not close
			e.printStackTrace();
		}
		
		Map<String, Integer> mapAecrireDansFichier = resultat.countOccurancesSymptome(symptomeDuFichier) ;
		
	
		try {
			resultat.ecrireSymptomeOccurancesDansFichier(mapAecrireDansFichier);
		} catch (FileWriterException e) {
			// File could not close
			e.printStackTrace();
		}
		
	}
}