package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

/**
 * Simple brute force implementation
 *
 */
public class ReadSymptomDataFromFile implements ISymptomReader {

	
	/**
	 * 
	 * @param filepath a full or partial path to file with symptom strings in it, one per line
	 */
	public ReadSymptomDataFromFile () {
	}
	
	@Override
	//GetSymptoms permet de lire et renvoi sous forme d'une liste le contenu du fichier texte "filepath"  
	public List<String> GetSymptoms(String filepath) throws streamException {
		ArrayList<String> result = new ArrayList<String>();
		
		if (filepath != null) {
			try {
				BufferedReader reader = new BufferedReader (new FileReader(filepath));
				String line = reader.readLine();
				
				while (line != null) {
					result.add(line);
					line = reader.readLine();
				}
				
				try {
				reader.close();
				} catch(IOException e) {
					throw new streamException("le flux ne s'est pas fermé correctement");
				}
			}catch (FileNotFoundException f) {
					f.getMessage();
					System.out.println("Fichier non trouvé");
			}
			 catch (IOException e) {
				e.printStackTrace();
				System.out.println("Le fichier ne peut pas être lu");
			}
			
		}
		
		return result;
	}
	
	//countOccurancesSymptome permet de compter le nombre d'occurences de chaque symptome
	public Map<String, Integer> countOccurancesSymptome (List<String> listSymptom){
		Map<String, Integer> toReturn = new TreeMap<String ,Integer>();
		for(String symptoms : listSymptom) {
			int occurrences = Collections.frequency(listSymptom, symptoms);
			toReturn.put(symptoms, occurrences);
			}
		return toReturn;
}
	File file = new File("results.out.txt");
	
	//ecrireSymptomeOccurancesDansFichier permet d'écrire dans un fichier texte le résultat obtenu par countOccurancesSymptome
	public void ecrireSymptomeOccurancesDansFichier(Map<String, Integer> laMap) throws FileWriterException {
		try {
		BufferedWriter writer = new BufferedWriter(new FileWriter(file));
		for(Entry<String, Integer> entry: laMap.entrySet()) {
			  writer.write(entry.getKey() + ":" + entry.getValue() + "\n");
			}
		
		try {
			writer.close();
		} catch(IOException e) {
			throw new FileWriterException("Le writer ne s'est pas fermé correctement");
		}
		
		}catch(FileNotFoundException f) {
			f.getMessage();
			System.out.println("Fichier non trouvé");
		}catch(IOException e) {
			e.printStackTrace();
			System.out.println("On ne peut pas écrire dans le fichier");
		}
	}
	
}
